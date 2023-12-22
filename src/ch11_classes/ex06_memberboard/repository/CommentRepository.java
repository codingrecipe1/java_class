package ch11_classes.ex06_memberboard.repository;

import ch11_classes.ex06_memberboard.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    private static List<CommentDTO> commentDTOList = new ArrayList<>();

    public boolean save(CommentDTO commentDTO) {
        return commentDTOList.add(commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (int i = 0; i < commentDTOList.size(); i++) {
            if (boardId.equals(commentDTOList.get(i).getBoardId())) {
                commentDTOS.add(commentDTOList.get(i));
            }
        }
        return commentDTOS;
    }
}
