package Stripe;

import java.util.*;


/*

Input Data:

3269 LANE 2811 PURCHASE 6\n2541 MISSION 951 PURCHASE 21\n6826 MISSION 1530 PURCHASE 22\n3269 LANE 7500 PAYMENT 19\n2541 MISSION 4260 PAYMENT 23\n3269 LANE 2756 PURCHASE 11\n4815 MISSION 701 PURCHASE 4\n3269 LANE 3732 PURCHASE 24\n6826 MISSION 1467 PURCHASE 8\n3269 LANE 3110 PURCHASE 15\n6826 MISSION 3491 PURCHASE 3\n6826 MISSION 3491 REFUND 17\n7482 LANE 4401 PURCHASE 7\n4815 MISSION 792 PURCHASE 5\n7482 LANE 2940 PURCHASE 14\n2541 MISSION 3309 PURCHASE 1\n4815 MISSION 1000 PAYMENT 10\n7482 LANE 1340 PURCHASE 20\n2541 MISSION 2888 PURCHASE 2\n4815 MISSION 1774 PURCHASE 13\n7482 LANE 4222 PURCHASE 26\n4815 MISSION 2116 PURCHASE 16\n2541 MISSION 2888 REFUND 9\n7482 LANE 7341 PAYMENT 18\n4815 MISSION 1000 PAYMENT 25\n6826 MISSION 3000 PAYMENT 12\n7482 LANE 5562 PAYMENT 28\n4815 MISSION 4460 PURCHASE 27

 ---

1. We have been provided a slice of transactions from our Credit Card product. Our financial analysts want us to calculate the Total Overall balance of these transactions in USD formatted as $xx.xx. ‘Amount’ is in cents, so 1025 = $10.25. Purchases increase the balance, Refunds and Payments decrease the balance.

Data is Structured as

Account_Number, Card_Type, Amount_in_Cents, Transaction_Type, Transaction_ID

Example:
1234 CC_A 1000 PURCHASE 1\n
9987 CC_B 600 PAYMENT 2

Answer: $4.00

---

2. Our financial analysts would also like the balance for each individual account. Additionally identify which accounts still have a remaining positive balance with us.

Example Answer:

1234 $10.00
7788 $0.00
6543 $5.15
[1234, 6543]

---

3. Product Management is considering adding a feature that will inform customers if they pass a certain threshold so that they can better prevent Over-Charging their card. Using this data identify which accounts would have received a notification for their given Card Type by playing back the transactions. Transactions occur in order based on the Transaction ID.

MISSION card type has a Threshold of $50.00.
LANE card type has a Threshold of $75.00.

The Transaction_Id is a globally unique auto incrementing Id. Each account has only one Card_Type.

Example Answer:

Notify 5324 LANE
Notify 9001 MISSION

 */

class MissionLane {
    public static void main(String[] args) {

        String data ="3269 LANE 2811 PURCHASE 6\n2541 MISSION 951 PURCHASE 21\n6826 MISSION 1530 PURCHASE 22\n3269 LANE 7500 PAYMENT 19\n2541 MISSION 4260 PAYMENT 23\n3269 LANE 2756 PURCHASE 11\n4815 MISSION 701 PURCHASE 4\n3269 LANE 3732 PURCHASE 24\n6826 MISSION 1467 PURCHASE 8\n3269 LANE 3110 PURCHASE 15\n6826 MISSION 3491 PURCHASE 3\n6826 MISSION 3491 REFUND 17\n7482 LANE 4401 PURCHASE 7\n4815 MISSION 792 PURCHASE 5\n7482 LANE 2940 PURCHASE 14\n2541 MISSION 3309 PURCHASE 1\n4815 MISSION 1000 PAYMENT 10\n7482 LANE 1340 PURCHASE 20\n2541 MISSION 2888 PURCHASE 2\n4815 MISSION 1774 PURCHASE 13\n7482 LANE 4222 PURCHASE 26\n4815 MISSION 2116 PURCHASE 16\n2541 MISSION 2888 REFUND 9\n7482 LANE 7341 PAYMENT 18\n4815 MISSION 1000 PAYMENT 25\n6826 MISSION 3000 PAYMENT 12\n7482 LANE 5562 PAYMENT 28\n4815 MISSION 4460 PURCHASE 27";

        Double totalBalance = 0.0;

        HashMap<String, TotalTransaction> accountBalance = new HashMap<>();

        for(String s: data.split("\n")){
            String[] elements = s.split(" ");
            String accountNumber  = elements[0];
            String type = elements[3];
            Double amount = Double.parseDouble(elements[2]);
            Transaction transaction = new Transaction(accountNumber,elements[1], amount, type, elements[4]);

            totalBalance = type.equalsIgnoreCase("PURCHASE")? totalBalance + amount: totalBalance - amount;
            if(accountBalance.containsKey(accountNumber)){
                TotalTransaction total = accountBalance.get(accountNumber);
                total.balance = type.equalsIgnoreCase("PURCHASE")? total.balance + amount: total.balance - amount;
                total.balanceHistory.add(total.balance);
                List<Transaction> transactions = total.transactions;
                transactions.add(transaction);
                total.transactions = transactions;
                accountBalance.put(accountNumber, total);
            }else{
                List<Transaction> transactions = new ArrayList<>();
                transactions.add(transaction);
                Double blnc = transaction.amountInCents;
                TotalTransaction total = new TotalTransaction(blnc, transactions);
                accountBalance.put(accountNumber, total);
            }



        }
        System.out.println("$"+ totalBalance/100.00);

        List<String> toAlert = new ArrayList<>();
        List<String> toAlertForHistory = new ArrayList<>();
        for(Map.Entry<String, TotalTransaction> entry: accountBalance.entrySet()){
            TotalTransaction tr = entry.getValue();
            if(tr.balance > 0.00){
                toAlert.add(entry.getKey());
            }
            int i = 0;
            for (Transaction transaction : tr.transactions) {
                if(transaction.cardType.equalsIgnoreCase("MISSION") && (tr.balanceHistory.get(i)/100.00)>50.00){
                    System.out.println("Notify " + transaction.accountNumber + " MISSION ");
                }else if(transaction.cardType.equalsIgnoreCase("LANE") && (tr.balanceHistory.get(i)/100.00)>75.00){
                    System.out.println("Notify " + transaction.accountNumber + " LANE ");
                }
                i++;
            }
        }

        System.out.println(String.join(",", toAlert));

    }
}

class TotalTransaction{
    Double balance;
    List<Double> balanceHistory = new ArrayList<>();
    List<Transaction> transactions;
    public TotalTransaction(Double balance, List<Transaction> tr){
        this.balance = balance;
        this.transactions = tr;
        this.balanceHistory.add(balance);
    }
}

class Transaction{
    String accountNumber;
    String cardType;
    Double amountInCents;
    String transactionType;
    String transactionID;

    public Transaction(String an, String ct, Double amount, String type,String id){
        this.accountNumber = an;
        this.cardType = ct;
        this.amountInCents = amount;
        this.transactionType = type;
        this.transactionID = id;
    }

}
