package ewhacodic.demo.controller;

import ewhacodic.demo.domain.Tech;
import ewhacodic.demo.domain.TechComment;
import ewhacodic.demo.dto.BoardCommentDto;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.dto.BoardListDto;
import ewhacodic.demo.service.TechService;
import ewhacodic.demo.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
public class TechController {
    @Autowired
    private TechService techService;

    public TechController(TechService techService) {
        this.techService = techService;
    }

    //추천순 게시글 정렬
    @GetMapping(value = "/order/recommend")
    public List<BoardDto> orderByRecommend() {
        return techService.getBoardList("recommend");
    }

    //조회순 게시글 정렬
    @GetMapping(value = "/order/view")
    public List<BoardDto> orderByView() {
        return techService.getBoardList("view");
    }

    //최신순 게시글 정렬
    @GetMapping(value = "/order/latest")
    public List<BoardDto> orderByLatest() {
        return techService.getBoardList("latest");
    }

    //댓글순 게시글 정렬
    @GetMapping(value = "/order/reply")
    public List<BoardDto> orderByReply() {
        return techService.getBoardList("reply");
    }

    //4. 게시글 하나 가져오기
    @GetMapping(value = "/{postId}")
    public BoardDto detail(@PathVariable("postId") Long postId) {
        BoardDto boardDto = techService.getPostOnly(postId);
        return boardDto;
    }

    //4-1. 특정 게시글의 댓글 조회
    @GetMapping("/{postId}/comment")
    public List<TechComment> getBoardComment(@PathVariable("postId") Long postId) {
        return techService.getCommentByPostId(postId);
    }

    //4-2. 특정 게시글 한번에 조회 -> 명세에 없음 + 엔드포인트 새로 구성
    @GetMapping("post2/{postId}")
    public Tech getBoardPostAndComment(@PathVariable("postId") Long postId) {
        return techService.getPostAndComment(postId);
    }

    // 5. 게시글 목록 조회
    @GetMapping("/list")
    public List<BoardListDto> getBoardList() {
        return techService.getBoardListDto();
    }

    /*//+
    @GetMapping("/list/page")
    public Page<BoardDto> getBoardListByPage(@PageableDefault(size=10) Pageable pageable, PagedResourcesAssembler assmebler){
        List<BoardListDto> boardListDto = boardService.getBoardListDto(pageable);
        return
    }*/


    //6. 게시글 작성
    @PostMapping("/new")
    public ResponseEntity<String> write(@RequestBody BoardDto boardDto) {
        System.out.println("controller");
        techService.savePost(boardDto);
        return ResponseEntity.ok("ok");
    }

    //7. 게시글 수정
    @PatchMapping(value = "/edit")
    public ResponseEntity<String> update(@RequestBody Tech tech) {
        techService.updatePost(tech);
        return ResponseEntity.ok("ok");
    }

    //8. 게시글 삭제
    @DeleteMapping(value = "/{postId}")
    public ResponseEntity<String> delete(@PathVariable("postId") Long id) {
        techService.deletePost(id);
        return ResponseEntity.ok("ok");
    }

    //9. 게시글 추천수 증가
    @PatchMapping(value = "/{postId}/recommend")
    public ResponseEntity<String> updateRecommend(@PathVariable("postId") Long id) {
        techService.updateBoardRecommend(id);

        return ResponseEntity.ok("ok");
    }

    //10. 댓글 작성
    @PostMapping("/{postId}/comment")
    public ResponseEntity<String> saveComment(@PathVariable Long postId, @RequestBody BoardCommentDto boardCommentDto) {
        techService.saveComment(boardCommentDto, postId);
        return ResponseEntity.ok("ok");
    }

    //11. 댓글 수정
    @PutMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody BoardCommentDto boardCommentDto) {
        techService.updateComment(postId, commentId, boardCommentDto);
        return ResponseEntity.ok("ok");
    }

    //12. 댓글 삭제
    @DeleteMapping("/{postId}/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        techService.deleteComment(commentId, postId);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/list/key")
    public List<BoardListDto> getBoardListByKeyWord(@RequestParam String keyword) {
        return techService.searchPosts(keyword);
    }
}
