package ewhacodic.demo.controller;

import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value="/codic/community")
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

//    //전체 게시글 목록 가져오기
//    @GetMapping(value="/get")
//    public Iterable<BoardDto> list(){
//        return boardService.getBoardList(null);
//    }

//    //추천순 게시글 정렬
//    @GetMapping(value="/order/recommend")
//    public List<BoardDto> orderByRecommend(){
//        return boardService.getBoardList("recommend");
//    }
//
//    //조회순 게시글 정렬
//    @GetMapping(value="/order/view")
//    public List<BoardDto> orderByView(){
//        return boardService.getBoardList("view");
//    }
//
//    //최신순 게시글 정렬
//    @GetMapping(value="/order/latest")
//    public List<BoardDto> orderByLatest(){
//        return boardService.getBoardList("latest");
//    }
//
//    //댓글순 게시글 정렬
//    @GetMapping(value="/order/reply")
//    public List<BoardDto> orderByReply(){
//        return boardService.getBoardList("reply");
//    }
//
//    //게시글 및 댓글 가져오기
//    @GetMapping(value="/{postId}")
//    public BoardDto detail(@PathVariable("postId") Long postId){
//        BoardDto boardDto = boardService.getPost(postId);
//        return boardDto;
//    }

    //게시글 작성
    @PostMapping(value="/newPost")
    public void write(BoardDto boardDto){
        boardService.savePost(boardDto);
    }

    //게시글 수정
    @PutMapping(value="/edit/{postId}")
    public void update(BoardDto boardDto){
        boardService.savePost(boardDto);
    }

    //게시글 삭제
    @DeleteMapping(value="/{postId}")
    public void delete(@PathVariable("postId") Long id){
        boardService.deletePost(id);
    }
}
