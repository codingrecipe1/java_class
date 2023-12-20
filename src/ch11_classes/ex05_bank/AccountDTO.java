package ch11_classes.ex05_bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDTO {
    private Long id;
    private String accountNumber;
    private long deposit;
    private long withdraw;
    private String bankingAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }

    private static Long idValue = 1L;

    public AccountDTO() {
    }

    public AccountDTO(String accountNumber, long deposit, long withdraw) {
        this.id = idValue++;
        this.accountNumber = accountNumber;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankingAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }
}

