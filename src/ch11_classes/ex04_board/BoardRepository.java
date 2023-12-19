package ch11_classes.ex04_board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO> boardDTOList = new ArrayList<>();
    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }
}
