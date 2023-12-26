package ch11_classes.ex06_memberboard.service;

import ch11_classes.ex06_memberboard.common.CommonVariables;
import ch11_classes.ex06_memberboard.dto.BoardDTO;
import ch11_classes.ex06_memberboard.dto.CommentDTO;
import ch11_classes.ex06_memberboard.repository.BoardRepository;
import ch11_classes.ex06_memberboard.repository.CommentRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner scanner = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();
    CommentRepository commentRepository = new CommentRepository();

    public void save() {
        System.out.print("제목: ");
        String boardTitle = scanner.next();
        System.out.print("내용: ");
        String boardContents = scanner.next();
        BoardDTO boardDTO = new BoardDTO(boardTitle, CommonVariables.loginEmail, boardContents);
        boolean result = boardRepository.save(boardDTO);
        if (result) {
            System.out.println("글작성 완료");
        } else {
            System.out.println("글작성 실패");
        }
    }

    public void findAll() {
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        listPrint(boardDTOList);
    }

    public void findById() {
        System.out.print("조회 id: ");
        Long id = scanner.nextLong();
        boolean result = boardRepository.updateHits(id);
        if (result) {
            BoardDTO boardDTO = boardRepository.findById(id);
            // 조회하는 게시글에 작성된 댓글 목록만 가져와야 함
            List<CommentDTO> commentDTOList = commentRepository.findAll(id);
            System.out.println("boardDTO = " + boardDTO);
            System.out.println("====== 댓글 ======");
            if (commentDTOList.size() > 0) {
                for (CommentDTO commentDTO : commentDTOList) {
                    System.out.println("commentDTO = " + commentDTO);
                }
            } else {
                System.out.println("작성된 댓글이 없습니다.");
            }
            System.out.println("댓글을 작성하시려면 1번을 입력해주세요.");
            System.out.println("메인메뉴로 돌아가려면 2번을 입력해주세요.");
            System.out.print("입력> ");
            int selectNo = scanner.nextInt();
            if (selectNo == 1) {
                System.out.print("댓글 내용: ");
                String commentContents = scanner.next();
                // 댓글을 작성할 때는 반드시 게시글 번호도 함께 저장되어야 함.
                CommentDTO commentDTO = new CommentDTO(id, CommonVariables.loginEmail, commentContents);
                boolean commentResult = commentRepository.save(commentDTO);
                if (commentResult) {
                    System.out.println("댓글작성 성공");
                } else {
                    System.out.println("댓글작성 실패");
                }
            } else if (selectNo == 2) {
                System.out.println("메인 메뉴로 돌아갑니다.");
            }
        } else {
            System.out.println("요청하신 게시글은 존재하지 않습니다!");
        }
    }

    public void update() {
        System.out.print("수정할 id: ");
        Long id = scanner.nextLong();
        BoardDTO boardDTO = boardRepository.findById(id);
        // 게시글도 존재하고 로그인한 회원이 작성한 글이라면
        if (boardDTO != null && CommonVariables.loginEmail.equals(boardDTO.getBoardWriter())) {
            System.out.print("수정 제목: ");
            String boardTitle = scanner.next();
            System.out.print("수정 내용: ");
            String boardContents = scanner.next();
            boolean result = boardRepository.update(id, boardTitle, boardContents);
            if (result) {
                System.out.println("수정 완료");
            } else {
                System.out.println("수정 실패");
            }
        } else if (!CommonVariables.loginEmail.equals(boardDTO.getBoardWriter())) {
            // 게시글은 있는데 작성한 회원이 아니라면
            System.out.println("작성자만 수정 가능합니다.");
        } else if (boardDTO == null) {
            System.out.println("요청하신 게시글은 존재하지 않습니다!");
        }
    }

    public void delete() {
        System.out.print("수정할 id: ");
        Long id = scanner.nextLong();
        BoardDTO boardDTO = boardRepository.findById(id);
        if (boardDTO != null && CommonVariables.loginEmail.equals(boardDTO.getBoardWriter())) {
            boolean result = boardRepository.delete(id);
            if (result) {
                System.out.println("삭제 완료");
            } else {
                System.out.println("삭제 실패");
            }
        } else if (!CommonVariables.loginEmail.equals(boardDTO.getBoardWriter())) {
            System.out.println("작성자만 삭제 가능합니다.");
        } else if (boardDTO == null) {
            System.out.println("요청하신 게시글은 존재하지 않습니다!");
        }
    }

    public void search() {
        System.out.print("검색어: ");
        String q = scanner.next();
        List<BoardDTO> searchList = boardRepository.search(q);
        if (searchList.size() > 0) {
            System.out.println("검색 결과");
            listPrint(searchList);
        } else {
            System.out.println("검색결과가 없습니다!");
        }
    }

    private void listPrint(List<BoardDTO> boardDTOList) {
        System.out.println("id\t" + "title\t" + "writer\t" + "hits\t" + "date\t");
        for (BoardDTO boardDTO : boardDTOList) {
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardTitle() + "\t" +
                    boardDTO.getBoardWriter() + "\t" + boardDTO.getBoardHits() + "\t" +
                    boardDTO.getCreatedAt() + "\t");
        }
    }

    public void testData() {
        for (int i = 1; i < 11; i++) {
            BoardDTO boardDTO = new BoardDTO("title" + i, "writer" + i, "contents" + i);
            boardRepository.save(boardDTO);
        }
    }
}

