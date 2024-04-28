package third;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Person {
    String name;
    String company;
    String address;
    String zipCode;
    String phone;
    String email;

    public Person(String name, String company, String address, String zipCode, String phone, String email) {
        this.name = name;
        this.company = company;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "\n" +
                "Company: " + company + "\n" +
                "Address: " + address + "\n" +
                "Zipcode: " + zipCode + "\n" +
                "Phones: " + phone + "\n" +
                "Email: " + email + "\n";
    }
}

class TreeNode {
    Person person;
    TreeNode left;
    TreeNode right;

    public TreeNode(Person person) {
        this.person = person;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return person.toString();
    }
}

class AddressBook {
    private TreeNode root;

    public AddressBook() {
        root = null;
    }

    public void insert(Person person) {
        root = insertRecursively(root, person);
    }

    private TreeNode insertRecursively(TreeNode node, Person person) {
        if (node == null) {
            return new TreeNode(person);
        }

        if (person.name.compareTo(node.person.name) < 0) {
            node.left = insertRecursively(node.left, person);
        } else if (person.name.compareTo(node.person.name) > 0) {
            node.right = insertRecursively(node.right, person);
        }

        return node;
    }

    public void list() {
        listInOrder(root);
    }

    private void listInOrder(TreeNode node) {
        if (node != null) {
        	listInOrder(node.left);
            System.out.print(node.person); 
            listInOrder(node.right);
        }
    }

	public Person find(String name) {
        return findRecursively(root, name);
    }

    private Person findRecursively(TreeNode node, String name) {
        if (node == null) {
            return null;
        }

        if (name.equals(node.person.name)) {
            return node.person;
        } else if (name.compareTo(node.person.name) < 0) {
            return findRecursively(node.left, name);
        } else {
            return findRecursively(node.right, name);
        }
    }

    public void add(String name, BufferedReader reader) throws IOException {
        if (find(name) != null) {
            System.out.println("Error: A person with the same name already exists.");
            return;
        }
        System.out.print("Company? ");
        String company = reader.readLine();
        System.out.print("Address? ");
        String address = reader.readLine();
        System.out.print("Zipcode? ");
        String zipCode = reader.readLine();
        System.out.print("Phone? ");
        String phone = reader.readLine();
        System.out.print("Email? ");
        String email = reader.readLine();
        insert(new Person(name, company, address, zipCode, phone, email));
        System.out.println(name + " was successfully added.");
    }

    public void trace(String name) {
        traceRecursively(root, name);
    }

    private boolean traceRecursively(TreeNode node, String name) {
        if (node == null) {
            return false;
        }
        if (name.equals(node.person.name)) {
            return true;
        }
        if (traceRecursively(node.left, name) || traceRecursively(node.right, name)) {
            System.out.println(node.person.name);
            return true;
        }
        return false;
    }

    public void delete(String name) {
        root = deleteRecursively(root, name);
    }

    private TreeNode deleteRecursively(TreeNode node, String name) {
        if (node == null) {
            return null;
        }

        if (name.equals(node.person.name)) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode minNode = findMin(node.right);
                node.person = minNode.person;
                node.right = deleteRecursively(node.right, minNode.person.name);
            }
        } else if (name.compareTo(node.person.name) < 0) {
            node.left = deleteRecursively(node.left, name);
        } else {
            node.right = deleteRecursively(node.right, name);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void save(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            saveRecursively(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveRecursively(TreeNode node, BufferedWriter writer) throws IOException {
        if (node != null) {
            saveRecursively(node.left, writer);
            writer.write(node.person.name + "\t" + node.person.company + "\t" + node.person.address + "\t" + node.person.zipCode + "\t" + node.person.phone + "\t" + node.person.email + "\n");
            saveRecursively(node.right, writer);
        }
    }
}

public class prob4 {
    public static void main(String[] args) throws IOException {
        String filename = "d:\\address_book2020.txt";
        AddressBook addressBook = readAddressBook(filename);

        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String command = parts[0];
            switch (command) {
                case "list":
                    addressBook.list();
                    break;
                case "find":
                    String nameToFind = parts[1];
                    Person foundPerson = addressBook.find(nameToFind);
                    if (foundPerson != null) {
                    	printPerson(foundPerson);
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case "add":
                    String nameToAdd = parts[1];
                    addressBook.add(nameToAdd, reader);
                    break;
                case "trace":
                    String nameToTrace = parts[1];
                    addressBook.trace(nameToTrace);
                    break;
                case "delete":
                    String nameToDelete = parts[1];
                    addressBook.delete(nameToDelete);
                    break;
                case "save":
                    String newFilename = parts[1];
                    addressBook.save(newFilename);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    public static AddressBook readAddressBook(String filename) throws IOException {
        AddressBook addressBook = new AddressBook();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                Person person = new Person(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                addressBook.insert(person);
            }
        }
        return addressBook;
    }


    public static void printPerson(Person person) {
        System.out.println(person.name);
        System.out.println("Company: " + person.company);
        System.out.println("Address: " + person.address);
        System.out.println("Zipcode: " + person.zipCode);
        System.out.println("Phones: " + person.phone);
        System.out.println("Email: " + person.email);
    }
}
