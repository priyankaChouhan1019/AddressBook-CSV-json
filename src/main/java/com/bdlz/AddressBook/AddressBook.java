package com.bdlz.AddressBook;

public class AddressBook {
    private final String cityForMap;
    public ArrayList<ContactDetails> name;
    Scanner sc = new Scanner(System.in);

    public AddressBook(String cityForMap) {
        this.cityForMap = cityForMap;
    }

    /*
    Declaring The Add Contact Method
    And Entering The Contact Details By Using Scanner Class
    And Printing The Contact Details Of Person
     */
    public ArrayList<ContactDetails> getAddressBook() {
        return contactList;
    }

    static ArrayList<ContactDetails> contactList = new ArrayList<>();

    /*
    Declaring check Duplicate Entry Method
    Checking For Duplicate Entries By Using Boolean Type
     */
    public boolean checkDuplicateEntry(ContactDetails contact) {
        boolean check = false;
        for (ContactDetails duplicateEntry : contactList) {
            if (duplicateEntry.equals(contact)) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    /*
    Declaring Search Person By City And FirstName
    Using Java Streams To Search By using CityName And FirstName
     */
    public static void searchPersonByCity(String cityName, String firstName) {
        List<ContactDetails> personList = contactList.stream().filter(p -> p.getCity().equalsIgnoreCase(cityName)).filter(p -> (p.getFirstName()).equalsIgnoreCase(firstName)).collect(Collectors.toList());
        for (ContactDetails contact : personList) {
            System.out.println("Search result: " + contact);
        }
    }

    /*
    Declaring The View Person Method By City Name
    Using Java Streams To View Contact By using City Name
     */
    public static void viewPersonByCity(String cityName1) {
        List<ContactDetails> list = contactList.stream().filter(g -> g.getCity().equalsIgnoreCase(cityName1)).collect(Collectors.toList());
        for (ContactDetails contact : list) {
            System.out.println("Contact List :" + contact);
        }
    }

    /*
   Declaring The Count Contacts Method By City Name
   Using Java Streams To Count The Contacts By using City Name
    */
    public static void countContactsByUsingCity(String cityName2) {
        long count = 0;
        long count1 = contactList.stream().filter(g -> g.getCity().equalsIgnoreCase(cityName2)).count();
        for (ContactDetails contact : contactList) {
            count1 += count;
        }
        System.out.println("Contact List :" + count1);
    }

    /*
      Declaring Sort Method
      Sorting The Details Of Contact By Using Names
     */
    public static void sortByName() {
        List<ContactDetails> list = contactList.stream().collect(Collectors.toList());
        list.stream().sorted((g1, g2) -> ((String) g1.getFirstName()).compareTo(g2.getFirstName()))
                .forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
    }

    /*
    Declaring Sort Method
    Sorting The Details Of Contact By City
    */
    public static void sortByCity() {
        List<ContactDetails> list = contactList.stream().collect(Collectors.toList());
        list.stream().sorted((g1, g2) -> ((String) g1.getCity()).compareTo(g2.getCity()))
                .forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
    }

    /*
    Declaring The Add Contact Method
    If Duplicate Entry Is Possible It Prints Person Already Exists
    And Printing The Contact Details Of Person
    */
    public boolean addContact(ContactDetails contact) {
        boolean entryCheck = checkDuplicateEntry(contact);
        if (!entryCheck) {
            contactList.add(contact);
            System.out.println("Contact added successfully!!");
        } else {
            System.out.println("The person already exists!!!");
        }
        System.out.println("Address Book Data : " + contactList);
        return true;
    }

    /*
    Declaring The Edit Contact Method
    TO Edit The Details Of Contact
    The Details Of Contact Edit By Using FirstName
    If First Name Is Match The Contact Will Edit
     */
    public void editContact(String firstName) {
        System.out.println(" Enter the first name of the contact : ");
        String checkName;
        Integer choice;
        for (ContactDetails contact : contactList) {
            checkName = contact.getFirstName();
            if (firstName.equalsIgnoreCase(checkName)) {
                do {
                    System.out.println("1. Edit First name" + "\n" + "2. Edit Last name" + "\n" + "3. Edit Address " + "\n" + "4. Edit City " + "\n" + "5. Edit State" + "\n" + "6. Edit Zipcode " + "\n" + "7. Edit Phone Number" + "\n" + "8. Edit Email" + "0. EXIT" + "\n" + "Enter your choice :");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new first name:");
                            String newFirstName = sc.next();
                            contact.setFirstName(newFirstName);
                            System.out.println(contact);
                            break;
                        case 2:
                            System.out.println("Enter new last name:");
                            String newLastName = sc.next();
                            contact.setLastName(newLastName);
                            System.out.println(contact);
                            break;
                        case 3:
                            System.out.println("Enter new address:");
                            String newAddress = sc.next();
                            contact.setAddress(newAddress);
                            System.out.println(contact);
                            break;
                        case 5:
                            System.out.println("Enter new state:");
                            String newState = sc.next();
                            contact.setState(newState);
                            System.out.println(contact);
                            break;
                        case 6:
                            System.out.println("Enter new zipcode:");
                            String newZipcode = sc.next();
                            contact.setZip(newZipcode);
                            System.out.println(contact);
                            break;
                        case 7:
                            System.out.println("Enter new phone number :");
                            String newPhone = sc.next();
                            contact.setPhoneNumber(newPhone);
                            System.out.println(contact);
                            break;
                        case 8:
                            System.out.println("Enter new email id:");
                            String newEmail = sc.next();
                            contact.setEmail(newEmail);
                            System.out.println(contact);
                            break;
                    }
                } while (!choice.equals(0));
                System.out.println(contact);
            } else {
                System.out.println("There is no contact named  " + firstName + ". Try Again !!");
            }
        }
    }

    /*
Declaring The Delete Contact Method
TO Details The Details Of Contact
The Details Of Contact Delete By Using FirstName
 */
    public void deleteContact(String firstName) {
        String checkName2;
        for (ContactDetails contact : contactList) {
            checkName2 = contact.getFirstName();
            System.out.println(checkName2);
            if (firstName.equalsIgnoreCase(checkName2)) {
                try {
                    contactList.remove(contact);
                    System.out.println("Contact name " + firstName + "deleted successfully from the contact list");
                } catch (Exception e) {
                    System.out.println("No any user belongs to this " + firstName + "  Try Again !!");
                }
            }
        }
    }
}
