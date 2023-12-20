package ch11_classes.ex05_bank;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    private static List<ClientDTO> clientDTOList = new ArrayList<>();
    private static List<AccountDTO> accountDTOList = new ArrayList<>();

    public ClientDTO accountCheck(String accountNumber) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                return clientDTO;
            }
        }
        return null;
    }

    public boolean save(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public ClientDTO checkBalance(String accountNumber) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                return clientDTO;
            }
        }
        return null;
    }

    public boolean deposit(String accountNumber, long money) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                long balance = clientDTO.getBalance();
                balance = balance + money;
                clientDTO.setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumber, money, 0);
                accountDTOList.add(accountDTO);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(String accountNumber, long money) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                long balance = clientDTO.getBalance();
                if (money > balance) {
                    return false;
                }
                balance = balance - money;
                clientDTO.setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumber, 0, money);
                accountDTOList.add(accountDTO);
                return true;
            }
        }
        return false;
    }

    public List<AccountDTO> bankingList(String accountNumber) {
        List<AccountDTO> bankingList = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber())) {
                bankingList.add(accountDTO);
            }
        }
        return bankingList;
    }

    public void transfer(String accountNumberFrom, String accountNumberTo, long money) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (accountNumberFrom.equals(clientDTOList.get(i).getAccountNumber())) {
                long balance = clientDTOList.get(i).getBalance();
                balance = balance - money;
                clientDTOList.get(i).setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumberFrom, 0, money);
                accountDTOList.add(accountDTO);
            } else if (accountNumberTo.equals(clientDTOList.get(i).getAccountNumber())) {
                long balance = clientDTOList.get(i).getBalance();
                balance = balance + money;
                clientDTOList.get(i).setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumberTo, money, 0);
                accountDTOList.add(accountDTO);
            }
        }
    }
}
