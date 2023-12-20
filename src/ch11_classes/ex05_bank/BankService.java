package ch11_classes.ex05_bank;

import java.util.List;
import java.util.Scanner;

public class BankService {
    BankRepository bankRepository = new BankRepository();
    Scanner scanner = new Scanner(System.in);
    public void save() {
        String accountNumber = null;
        ClientDTO clientDTO = null;
        do {
            System.out.print("계좌번호: ");
            accountNumber = scanner.next();
            clientDTO = bankRepository.accountCheck(accountNumber);
            if (clientDTO == null) {
                System.out.println("사용 가능한 계좌번호 입니다.");
            } else {
                System.out.println("이미 사용 중인 계좌번호 입니다.");
            }
        } while (clientDTO != null);
        System.out.print("비밀번호: ");
        String clientPass = scanner.next();
        System.out.print("이름: ");
        String clientName = scanner.next();
        ClientDTO newClient = new ClientDTO(clientName, accountNumber, clientPass);
        boolean result = bankRepository.save(newClient);
        if (result) {
            System.out.println("고객등록 성공");
        } else {
            System.out.println("고객등록 실패");
        }
    }

    public void checkBalance() {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        ClientDTO clientDTO = bankRepository.checkBalance(accountNumber);
        if (clientDTO != null) {
            System.out.println(clientDTO.getClientName() + "님의 잔액은 " + clientDTO.getBalance() + "원 입니다.");
        } else {
            System.out.println("없는 계좌번호 입니다!");
        }
    }

    public void deposit() {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("입금액: ");
        long money = scanner.nextLong();
        ClientDTO clientDTO = bankRepository.accountCheck(accountNumber);
        if (clientDTO != null) {
            boolean result = bankRepository.deposit(accountNumber, money);
            if (result) {
                System.out.println("입금 완료");
            } else {
                System.out.println("입금 실패");
            }
        } else {
            System.out.println("해당 계좌가 없습니다.");
        }
    }

    public void withdraw() {
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("비밀번호: ");
        String clientPass = scanner.next();
        System.out.print("출금액: ");
        long money = scanner.nextLong();
        ClientDTO clientDTO = bankRepository.accountCheck(accountNumber);
        if (clientDTO != null && clientPass.equals(clientDTO.getClientPass())) {
            boolean result = bankRepository.withdraw(accountNumber, money);
            if (result) {
                System.out.println("출금 완료");
            } else {
                System.out.println("잔액이 부족합니다");
            }
        } else {
            System.out.println("해당 계좌가 없거나 비밀번호가 틀립니다!");
        }
    }

    public void bankingList() {
        boolean run = true;
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        int selectNo = 0;
        ClientDTO clientDTO = bankRepository.accountCheck(accountNumber);
        if (clientDTO != null) {
            while (run) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("1.모든 내역 | 2.입금 내역 | 3.출금 내역 | 4.종료 ");
                System.out.println("-----------------------------------------------------------------------");
                System.out.print("선택> ");
                selectNo = scanner.nextInt();
                List<AccountDTO> accountDTOList = bankRepository.bankingList(accountNumber);
                if (accountDTOList.size() > 0) {
                    if (selectNo == 1) {
                        for (AccountDTO accountDTO : accountDTOList) {
                            System.out.println("accountDTO = " + accountDTO);
                        }
                    } else if (selectNo == 2) {
                        for (AccountDTO accountDTO : accountDTOList) {
                            if (accountDTO.getDeposit() > 0) {
                                System.out.println("accountDTO = " + accountDTO);
                            }
                        }
                    } else if (selectNo == 3) {
                        for (AccountDTO accountDTO : accountDTOList) {
                            if (accountDTO.getWithdraw() > 0) {
                                System.out.println("accountDTO = " + accountDTO);
                            }
                        }
                    } else if (selectNo == 4) {
                        run = false;
                    }
                } else {
                    System.out.println("거래내역이 없습니다!");
                }
            }
        } else {
            System.out.println("해당 계좌가 없습니다!");
        }
    }

    public void transfer() {
        System.out.print("보내실 분 계좌번호: ");
        String accountNumberFrom = scanner.next();
        System.out.print("받으실 분 계좌번호: ");
        String accountNumberTo = scanner.next();
        System.out.print("보낼 금액: ");
        long money = scanner.nextLong();
        ClientDTO clientTo = bankRepository.accountCheck(accountNumberTo);
        ClientDTO clientFrom = bankRepository.accountCheck(accountNumberFrom);
        if (clientTo != null && clientFrom !=null) {
            System.out.println("받으실 분이 " + clientTo.getClientName() + "님이 맞습니까?");
            System.out.println("맞으면 1번, 틀리면 2번을 입력해주세요.");
            System.out.print("입력> ");
            int selectNo = scanner.nextInt();
            if (selectNo == 1) {
                System.out.print("비밀번호를 입력해주세요: ");
                String clientPass = scanner.next();
                if (clientPass.equals(clientFrom.getClientPass()) && money <= clientFrom.getBalance()) {
                    bankRepository.transfer(accountNumberFrom, accountNumberTo, money);
                    System.out.println("이체가 완료되었습니다. ");
                } else if (!clientPass.equals(clientFrom.getClientPass())) {
                    System.out.println("비밀번호가 틀립니다!");
                } else if (money > clientFrom.getBalance()) {
                    System.out.println("잔액이 부족합니다!");
                }
            } else if (selectNo == 2) {
                System.out.println("메인메뉴로 돌아갑니다.");
            }
        } else {
            System.out.println("해당 계좌가 없습니다.");
        }
    }
}
