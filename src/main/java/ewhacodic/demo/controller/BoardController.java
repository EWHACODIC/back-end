package ewhacodic.demo.controller;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class BoardController {

    @Autowired
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

//    //전체 게시글 목록 가져오기
//    @GetMapping(value="/get")
//    public Iterable<BoardDto> list(){
//        return boardService.getBoardList(null);
//    }
//
    //추천순 게시글 정렬
    @GetMapping(value="/order/recommend")
    public List<BoardDto> orderByRecommend(){
        return boardService.getBoardList("recommend");
    }

    //조회순 게시글 정렬
    @GetMapping(value="/order/view")
    public List<BoardDto> orderByView(){
        return boardService.getBoardList("view");
    }

    //최신순 게시글 정렬
    @GetMapping(value="/order/latest")
    public List<BoardDto> orderByLatest(){
        return boardService.getBoardList("latest");
    }

    //댓글순 게시글 정렬
    @GetMapping(value="/order/reply")
    public List<BoardDto> orderByReply(){
        return boardService.getBoardList("reply");
    }

    //4. 게시글 하나 가져오기
    @GetMapping(value="/{postId}")
    public BoardDto detail(@PathVariable("postId") Long postId){
        BoardDto boardDto = boardService.getPostOnly(postId);
        return boardDto;
    }

    //4-1. 특정 게시글의 댓글 조회
    @GetMapping("/{postId}/comment")
    public List<BoardComment> getBoardComment(@PathVariable("postId") Long postId) {
        return boardService.getCommentByPostId(postId);
    }

    //4-2. 특정 게시글 한번에 조회 -> 명세에 없음 + 엔드포인트 새로 구성
    @GetMapping("post2/{postId}")
    public Board getBoardPostAndComment(@PathVariable("postId") Long postId) {
        return boardService.getPostAndComment(postId);
    }

    // 5. 게시글 목록 조회
    @GetMapping("/list")
    public List<BoardListDto> getBoardList() {
        return boardService.getBoardListDto();
    }


    //6. 게시글 작성
    @PostMapping("/new")
    public ResponseEntity<String> write(@RequestBody BoardDto boardDto){
        System.out.println("controller");
        boardService.savePost(boardDto);
        return ResponseEntity.ok("ok");
    }

    //7. 게시글 수정
    @PatchMapping(value="/edit")
    public ResponseEntity<String> update(@RequestBody Board board){
        boardService.updatePost(board);
        return ResponseEntity.ok("ok");
    }

    //8. 게시글 삭제
    @DeleteMapping(value="/{postId}")
    public ResponseEntity<String> delete(@PathVariable("postId") Long id){
        boardService.deletePost(id);
        return ResponseEntity.ok("ok");
    }

    //9. 게시글 추천수 증가
    @PatchMapping(value="/{postId}/recommend")
    public ResponseEntity<String> updateRecommend(@PathVariable("postId") Long id){
        boardService.updateBoardRecommend(id);

        return ResponseEntity.ok("ok");
    }

    //10. 댓글 작성
    @PostMapping("/{postId}/comment")
    public ResponseEntity<String> saveComment(@PathVariable Long postId, @RequestBody BoardCommentDto boardCommentDto) {
        boardService.saveComment(boardCommentDto, postId);
        return ResponseEntity.ok("ok");
    }

    //11. 댓글 수정
    @PutMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody BoardCommentDto boardCommentDto) {
        boardService.updateComment(postId, commentId, boardCommentDto);
        return ResponseEntity.ok("ok");
    }

    //12. 댓글 삭제
    @DeleteMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        boardService.deleteComment(commentId, postId);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/list/key")
    public List<BoardListDto> getBoardListByKeyWord(@RequestParam String keyword) {
        return boardService.searchPosts(keyword);
    }



}
