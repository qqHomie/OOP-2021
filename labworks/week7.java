public class week7 {
    public static void main(String[] args) {
        Client firstClient = new Client("Nurs", "8-(777)-777-77-77", "1");

        System.out.println(firstClient.getName());
        Client.setName(firstClient, "Nurislam");
        System.out.println(firstClient.getName());

        System.out.println(firstClient.getPhone());
        Client.setPhone(firstClient, "8-(777)-666-66-55");
        System.out.println(firstClient.getPhone());

        System.out.println(firstClient.getId());
    
        BankAccount firstBankAccount = new BankAccount("6666 6666 6666 6666", "active", firstClient);
     
        System.out.println(firstBankAccount.getStatus());
        BankAccount.setStatus(firstBankAccount, "deleted");
        System.out.println(firstBankAccount.getStatus());

        System.out.println(firstBankAccount.getNumber());
        System.out.println(firstBankAccount.getClient().getName());
                
        Bank firstBank = new Bank("Halyk Bank");

        System.out.println(firstBank.getName());
        Bank.setName(firstBank, "Forte Bank");
        System.out.println(firstBank.getName());

        System.out.println(firstBank.countAccount());
        firstBank.createBankAccount(firstBankAccount);
        System.out.println(firstBank.countAccount());

        firstBank.createClient(firstClient);
        System.out.println(firstBank.countClients());
        System.out.println(firstBank.makeReport());
    }
}

class Client {
    private String name;
    private String phone;
    public String id;
    
    Client(String name, String phone, String id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }
    
    static void setName(Client c, String newName) {
        c.name = newName;
    }

 

    public String getName() {
        return "Client: " + this.name;
    }
    
    public String getId() {
        return "ID: " + this.id;
    }
    
    static void setPhone(Client c, String newPhone) {
        c.phone = newPhone;
    }

 

    public String getPhone() {
        return "Phone: " + this.phone;
    }
}

 


class BankAccount {
    private String number;
    private String status;
    public Client owner;
    
    BankAccount(String number, String status, Client owner) {
        this.number = number;
        this.status = status;
        this.owner = owner;
    }
    
    static void setStatus(BankAccount bankAccount, String newStatus) {
        bankAccount.status = newStatus;
    }
    
    public String getStatus() {
        return "Status: " + this.status;
    }

 

    public String getNumber() {
        return "Number: " + this.number;
    }
    
    public Client getClient() {
        return this.owner;
    }
}

 


class Bank {
    private Client[] clients;
    private BankAccount[] accounts;
    private int accountsCount;
    private int clientsCount;
    public String name;
    
    Bank(String name) {
        this.name = name;
        this.clients = new Client[100]; 
        this.accounts = new BankAccount[100]; 
    }
    
    static void setName(Bank b, String newName) {
        b.name = newName;
    }


    public String getName() {
        return "Bank: " + this.name;
    }

    public void createBankAccount(BankAccount bankAccount) {
        if (this.accountsCount < 100 ) {
            this.accounts[accountsCount] = bankAccount;
            accountsCount++;
        }
    }

    public void createClient(Client theClient) {
        if (this.clientsCount < 100 ) {
            this.clients[clientsCount] = theClient;
            clientsCount++;
        }
    }
    
    public String makeReport(){
        return this.clients[this.clientsCount - 1].getId() + " " + this.clients[this.clientsCount - 1].getName() + " " + this.accounts[this.accountsCount - 1].getStatus();
    }


    public String countAccount() {
        return "Count Account: " + this.accountsCount;
    }

    public String countClients(){
        return "Count Clients: " + this.clientsCount;
    }
}

