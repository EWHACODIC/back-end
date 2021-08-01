package ewhacodic.demo.controller;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.domain.BoardComment;
import ewhacodic.demo.domain.Qna;
import ewhacodic.demo.domain.QnaComment;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.service.BoardService;
import ewhacodic.demo.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/qna")
public class QnaController {

    @Autowired
    private QnaService qnaService;

    public QnaController(BoardService boardService){
        this.qnaService = qnaService;
    }

//    //추천순 게시글 정렬
//    @GetMapping(value="/order/recommend")
//    public List<BoardDto> orderByRecommend(){
//        return qnaService.getBoardList("recommend");
//    }
//
//    //조회순 게시글 정렬
//    @GetMapping(value="/order/view")
//    public List<BoardDto> orderByView(){
//        return qnaService.getBoardList("view");
//    }
//
//    //최신순 게시글 정렬
//    @GetMapping(value="/order/latest")
//    public List<BoardDto> orderByLatest(){
//        return qnaService.getBoardList("latest");
//    }

    //댓글순 게시글 정렬
    @GetMapping(value="/order/reply")
    public List<BoardDto> orderByReply(){
        return qnaService.getBoardList("reply");
    }

    //4. 게시글 하나 가져오기
    @GetMapping(value="/{postId}")
    public BoardDto detail(@PathVariable("postId") Long postId){
        BoardDto boardDto = qnaService.getPostOnly(postId);
        return boardDto;
    }

    //4-1. 특정 게시글의 댓글 조회
    @GetMapping("/{postId}/comment")
    public List<QnaComment> getBoardComment(@PathVariable("postId") Long postId) {
        return qnaService.getCommentByPostId(postId);
    }

    //4-2. 특정 게시글 한번에 조회 -> 명세에 없음 + 엔드포인트 새로 구성
    @GetMapping("post2/{postId}")
    public Qna getBoardPostAndComment(@PathVariable("postId") Long postId) {
        return qnaService.getPostAndComment(postId);
    }

    // 5. 게시글 목록 조회
    @GetMapping("/list")
    public List<BoardListDto> getBoardList(Pageable pageable) {
        return qnaService.getBoardListDto(pageable);
    }

    /*//+
    @GetMapping("/list/page")
    public Page<BoardDto> getBoardListByPage(@PageableDefault(size=10) Pageable pageable, PagedResourcesAssembler assmebler){
        List<BoardListDto> boardListDto = boardService.getBoardListDto(pageable);
        return
    }*/


    //6. 게시글 작성
    @PostMapping("/new")
    public ResponseEntity<String> write(@RequestBody BoardDto boardDto){
        System.out.println("controller");
        qnaService.savePost(boardDto);
        return ResponseEntity.ok("ok");
    }

    //7. 게시글 수정
    @PatchMapping(value="/edit")
    public ResponseEntity<String> update(@RequestBody BoardDto qna){
        qnaService.updatePost(qna);
        return ResponseEntity.ok("ok");
    }

    //8. 게시글 삭제
    @DeleteMapping(value="/{postId}")
    public ResponseEntity<String> delete(@PathVariable("postId") Long id){
        qnaService.deletePost(id);
        return ResponseEntity.ok("ok");
    }

    //9. 게시글 추천수 증가
    @PatchMapping(value="/{postId}/recommend/{userCode}")
    public ResponseEntity<String> updateRecommend(@PathVariable("postId") Long id, @PathVariable("userCode") Long userCode){
        qnaService.updateBoardRecommend(id, userCode);

        return ResponseEntity.ok("ok");
    }

    //10. 댓글 작성
    @PostMapping("/{postId}/comment")
    public ResponseEntity<String> saveComment(@PathVariable Long postId, @RequestBody BoardCommentDto boardCommentDto) {
        qnaService.saveComment(boardCommentDto, postId);
        qnaService.updateCommentCount(postId);
        return ResponseEntity.ok("ok");
    }

    //11. 댓글 수정
    @PutMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody BoardCommentDto boardCommentDto) {
        qnaService.updateComment(postId, commentId, boardCommentDto);
        return ResponseEntity.ok("ok");
    }

    //12. 댓글 삭제
    @DeleteMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        qnaService.deleteComment(commentId, postId);
        qnaService.updateCommentCount(postId);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/list/key")
    public List<BoardListDto> getBoardListByKeyWord(@RequestParam String keyword) {
        return qnaService.searchPosts(keyword);
    }

    @GetMapping("/list/total")
    public long totalPosts(@RequestBody List<BoardListDto> boardListDtos){
        return qnaService.totalPosts(boardListDtos);
    }

    @GetMapping("/list/total/count")
    public Long totalPostCount() {
        return qnaService.totalPosts();
    }
}
