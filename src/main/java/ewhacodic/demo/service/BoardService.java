package ewhacodic.demo.service;

import ewhacodic.demo.domain.Board;
import ewhacodic.demo.dto.BoardDto;
import ewhacodic.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService{
    @Autowired
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public BoardDto getPost(Long id){
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .tag(board.getTag())
                .view(board.getView())
                .user_id(board.getUser_id())
                .createDate(board.getCreatedDate())
                .modifiedDate(board.getModifiedDate())
                .build();
        boardDto.updateView();

        return boardDto;
    }

    @Transactional
    public List<BoardDto> getBoardList(String order){
        List<Board> boardList;
        if(order.equals("latest")){
            boardList = boardRepository.OrderByLatest();
        } else if(order.equals("recommend")){
            boardList = boardRepository.OrderByRecommend();
        } else if(order.equals("view")){
            boardList = boardRepository.OrderByView();
        } else if(order.equals("reply")){
            boardList = boardRepository.OrderByReply();
        } else {
            boardList = boardRepository.findPosts();
        }
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board:boardList){
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .tag(board.getTag())
                    .view(board.getView())
                    .recommend(board.getRecommend())
                    .user_id(board.getUser_id())
                    .createDate(board.getCreatedDate())
                    .modifiedDate(board.getModifiedDate())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }
}
