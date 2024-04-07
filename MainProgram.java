import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 @author <Pham Thanh The - S3981133>
*/

public class MainProgram {
    public static void main(String[] args) throws IOException {
        List<PolicyHolder> policyHolders = new ArrayList<>();
        List<Claim> claims = new ArrayList<>();
        List<Dependent> dependents = new ArrayList<>();

        fileReading.readPolicyHolderFromFile(policyHolders);
        fileReading.readClaimFromFile(claims);
        fileReading.readDependentFromFile(dependents);
        Generator.setClaimToPolicyHolder(policyHolders, claims);
        Generator.setClaimToDependent(dependents, claims);
        Generator.setDependentToPolicyHolder(policyHolders, dependents);

        while (true) {
            System.out.println("**WELCOME TO INSURANCE CLAIMS MANAGEMENT PROGRAM**");
            System.out.println("1.View All Policy Holders | 8.Delete A Dependent");
            System.out.println("2.Search Policy Holder    | 9.View All Claims");
            System.out.println("3.Add A Policy Holder     | 10.Search Claim");
            System.out.println("4.Delete A Policy Holder  | 11.Add A Claim");
            System.out.println("5.View All Dependents     | 12.Delete A Claim");
            System.out.println("6.Search Dependent        | 13.Update A Claim");
            System.out.println("7.Add A Dependent         | 14.Exit");
            System.out.print("Enter Your Choice: ");
            Scanner scanChoice = new Scanner(System.in);
            int choice = scanChoice.nextInt();
            while (choice < 0 || choice > 14) {
                System.out.print("Enter Your Choice: ");
                choice = scanChoice.nextInt();
            }
            if (choice == 1) {
                System.out.println();
                System.out.println("All Policy Holders In The System: \n");
                System.out.println(policyHolders);
                System.out.println();
            }
            if (choice == 2) {
                System.out.println();
                String pH_ID = "";
                while (pH_ID.length() != 11) {
                    System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                    Scanner scanID = new Scanner(System.in);
                    pH_ID = scanID.next();
                }
                boolean findPH = false;
                for (PolicyHolder aPH:policyHolders) {
                    if (aPH.getCustomerID().equals(pH_ID)) {
                        System.out.println(aPH);
                        findPH = true;
                        System.out.println();
                    }
                }
                if (!findPH) {
                    System.out.println("There is no Policy Holder with ID " + pH_ID);
                    System.out.println();
                }
            }
            if (choice == 3) {
                System.out.println();
                PolicyHolder newPolicyHolder = new PolicyHolder();
                Generator.createPolicyHolder(newPolicyHolder);
                Iterator<PolicyHolder> iterator = policyHolders.iterator();
                while (iterator.hasNext()) {
                    PolicyHolder aPH = iterator.next();
                    if (!(aPH.getCustomerID().equals(newPolicyHolder.getCustomerID()))) {
                        policyHolders.add(newPolicyHolder);
                        System.out.println("Policy Holder " + newPolicyHolder.getFullName() + " is created");
                        break;
                    }
                    else {
                        System.out.println("There is an error while creating New Dependent: Duplicate ID");
                        break;
                    }
                }
            }
            if (choice == 4) {
                System.out.println();
                String pH_ID = "";
                while (pH_ID.length() != 11) {
                    System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                    Scanner scanID = new Scanner(System.in);
                    pH_ID = scanID.next();
                }

                boolean findPH = false;
                Iterator<PolicyHolder> iterator = policyHolders.iterator();
                while (iterator.hasNext()) {
                    PolicyHolder aPH = iterator.next();
                    if (aPH.getCustomerID().equals(pH_ID)) {
                        findPH = true;
                        policyHolders.remove(aPH);
                        System.out.println("Policy Holder with ID " + pH_ID + " is deleted");
                        System.out.println();
                        break;
                    }
                }
                if (!findPH) {
                    System.out.println("There is no Policy Holder with ID " + pH_ID);
                    System.out.println();
                }
            }
            if (choice == 5) {
                System.out.println();
                System.out.println("All Dependents In The System: \n");
                System.out.println(dependents);
                System.out.println();
            }
            if (choice == 6) {
                System.out.println();
                String dP_ID = "";
                while (dP_ID.length() != 11) {
                    System.out.print("Enter Dependent's ID ('C' + 10 number digits): ");
                    Scanner scanID = new Scanner(System.in);
                    dP_ID = scanID.next();
                }
                boolean findDP = false;
                for (Dependent aDp:dependents) {
                    if (aDp.getCustomerID().equals(dP_ID)) {
                        System.out.println(aDp);
                        findDP = true;
                        System.out.println();
                    }
                }
                if (!findDP) {
                    System.out.println("There is no Dependent with ID " + dP_ID);
                    System.out.println();
                }
            }
            if (choice == 7) {
                System.out.println();
                System.out.println("All Policy Holders In The System: \n");
                System.out.println(policyHolders);
                System.out.println();
                String pH_ID = "";
                while (pH_ID.length() != 11) {
                    System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                    Scanner scanID = new Scanner(System.in);
                    pH_ID = scanID.next();
                }

                boolean findPH = false;
                Iterator<PolicyHolder> iterator = policyHolders.iterator();
                while (iterator.hasNext()) {
                    PolicyHolder aPH = iterator.next();

                    if (aPH.getCustomerID().equals(pH_ID)) {
                        findPH = true;
                        Dependent newDependent = new Dependent();
                        Generator.createDependent(newDependent);
                        if (aPH.getFullName().equals(newDependent.getPolicyHolderName())
                                && aPH.getPolicyOwner().equals(newDependent.getInsuranceCard().getPolicyOwner())
                                && aPH.checkDependentID(newDependent.getCustomerID())) {
                            newDependent.setPolicyHolder(aPH);
                            aPH.addDependent(newDependent);
                            dependents.add(newDependent);
                            System.out.println("Dependent is created and added to Policy Holder with ID " + pH_ID);
                            System.out.println();
                            break;
                        } else {
                            System.out.println("There is an error while creating New Dependent: Duplicate ID, Not Correct Policy Holder's Name...");
                            break;
                        }
                    }
                }
                if (!findPH) {
                    System.out.println("There is no Policy Holder with ID " + pH_ID);
                    System.out.println();
                }
            }
            if (choice == 8) {
                System.out.println();
                String pH_ID = "";
                while (pH_ID.length() != 11) {
                    System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                    Scanner scanID = new Scanner(System.in);
                    pH_ID = scanID.next();
                }

                boolean findPH = false;
                Iterator<PolicyHolder> iterator1 = policyHolders.iterator();
                while (iterator1.hasNext()) {
                    PolicyHolder aPH = iterator1.next();
                    if (aPH.getCustomerID().equals(pH_ID)) {
                        findPH = true;
                        boolean findDP = false;
                        String dP_ID = "";
                        while (dP_ID.length() != 11) {
                            System.out.print("Enter Dependent's ID ('C' + 10 number digits): ");
                            Scanner scanID1 = new Scanner(System.in);
                            dP_ID = scanID1.next();
                        }
                        Iterator<Dependent> iterator = dependents.iterator();
                        while (iterator.hasNext()) {
                            Dependent aDp = iterator.next();
                            if (aDp.getCustomerID().equals(dP_ID)) {
                                findDP = true;
                                aPH.getDependentList().remove(aDp);
                                dependents.remove(aDp);
                                System.out.println("Dependent with ID " + dP_ID + " is deleted");
                                System.out.println();
                                break;
                            }
                        }
                        if (!findDP) {
                            System.out.println("There is no Dependent with ID " + dP_ID);
                            System.out.println();
                        }

                    }
                }
                if (!findPH) {
                    System.out.println("There is no Policy Holder with ID " + pH_ID);
                    System.out.println();
                }

            }
            if (choice == 9) {
                System.out.println();
                int claimChoice = 0;
                while (claimChoice < 1 || claimChoice > 3) {
                    System.out.println("1.View All Claims In The System");
                    System.out.println("2.View All Claims Of A Policy Holder");
                    System.out.println("3.View All Claims Of A Dependent");
                    System.out.print("Enter Your Choice: ");
                    Scanner scanClaimChoice = new Scanner(System.in);
                    claimChoice = scanClaimChoice.nextInt();
                }
                if (claimChoice == 1) {
                    System.out.println();
                    System.out.println("All Claims In The System: \n");
                    System.out.println(claims);
                    System.out.println();
                }
                if (claimChoice == 2) {
                    System.out.println();
                    String pH_ID = "";
                    while (pH_ID.length() != 11) {
                        System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        pH_ID = scanID.next();
                    }

                    boolean findPH = false;
                    Iterator<PolicyHolder> iterator = policyHolders.iterator();
                    while (iterator.hasNext()) {
                        PolicyHolder aPH = iterator.next();
                        if (aPH.getCustomerID().equals(pH_ID)) {
                            findPH = true;
                            System.out.println(aPH.getAll());
                            System.out.println();
                            break;
                        }
                    }
                    if (!findPH) {
                        System.out.println("There is no Policy Holder with ID " + pH_ID);
                        System.out.println();
                    }
                }
                if (claimChoice == 3) {
                    System.out.println();
                    String dP_ID = "";
                    while (dP_ID.length() != 11) {
                        System.out.print("Enter Dependent's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        dP_ID = scanID.next();
                    }

                    boolean findDP = false;
                    Iterator<Dependent> iterator = dependents.iterator();
                    while (iterator.hasNext()) {
                        Dependent aDp = iterator.next();
                        if (aDp.getCustomerID().equals(dP_ID)) {
                            findDP = true;
                            System.out.println(aDp.getAll());
                            System.out.println();
                            break;
                        }
                    }
                    if (!findDP) {
                        System.out.println("There is no Dependent with ID " + dP_ID);
                        System.out.println();
                    }
                }

            }
            if (choice == 10) {
                System.out.println();
                String claim_ID = "";
                while (claim_ID.length() != 11) {
                    System.out.print("Enter Claim's ID ('F' + 10 number digits): ");
                    Scanner scanID = new Scanner(System.in);
                    claim_ID = scanID.next();
                }
                boolean findCl = false;
                for (Claim aClaim:claims) {
                    if (aClaim.getClaimID().equals(claim_ID)) {
                        System.out.println(aClaim);
                        findCl = true;
                        System.out.println();
                    }
                }
                if (!findCl) {
                    System.out.println("There is no Claim with ID " + claim_ID);
                    System.out.println();
                }
            }
            if (choice == 11) {
                System.out.println();
                int claimChoice = 0;
                while (claimChoice < 1 || claimChoice > 2) {
                    System.out.println("1.Add A Claim Of A Policy Holder");
                    System.out.println("2.Add A Claim Of Dependent");
                    System.out.print("Enter Your Choice: ");
                    Scanner scanClaimChoice = new Scanner(System.in);
                    claimChoice = scanClaimChoice.nextInt();
                }
                System.out.println();

                boolean findClaim = false;
                if (claimChoice == 1) {
                    System.out.println(policyHolders);
                    String pH_ID = "";
                    while (pH_ID.length() != 11) {
                        System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        pH_ID = scanID.next();
                    }

                    boolean findPH = false;
                    Iterator<PolicyHolder> iterator = policyHolders.iterator();
                    while (iterator.hasNext()) {
                        PolicyHolder aPH = iterator.next();
                        if (aPH.getCustomerID().equals(pH_ID)) {
                            findPH = true;
                            Claim newClaim = new Claim();
                            ReceiverBankingInfo bankingInfo = new ReceiverBankingInfo();
                            Generator.createClaim(newClaim, aPH, bankingInfo);
                            if (aPH.checkClaimID(newClaim.getClaimID())) {
                                aPH.add(newClaim);
                                claims.add(newClaim);
                                System.out.println("New Claim is created and added to Policy Holder with ID " + pH_ID);
                                System.out.println();
                                break;
                            } else {
                                System.out.println("There is an error while creating NEW Claim");
                                break;
                            }
                        }
                    }
                    if (!findPH) {
                        System.out.println("There is no Policy Holder with ID " + pH_ID);
                        System.out.println();
                    }
                }

                if (claimChoice == 2) {
                    System.out.println(dependents);
                    String dP_ID = "";
                    while (dP_ID.length() != 11) {
                        System.out.print("Enter Dependent's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        dP_ID = scanID.next();
                    }

                    boolean findDP = false;
                    Iterator<Dependent> iterator = dependents.iterator();
                    while (iterator.hasNext()) {
                        Dependent aDp = iterator.next();
                        if (aDp.getCustomerID().equals(dP_ID)) {
                            findDP = true;
                            Claim newClaim = new Claim();
                            ReceiverBankingInfo bankingInfo = new ReceiverBankingInfo();
                            Generator.createClaim(newClaim, aDp, bankingInfo);
                            if (aDp.checkClaimID(newClaim.getClaimID())) {
                                aDp.add(newClaim);
                                claims.add(newClaim);
                                System.out.println("New Claim is created and added to Dependent with ID " + dP_ID);
                                System.out.println();
                                break;
                            } else {
                                System.out.println("There is an error while creating NEW Claim");
                                break;
                            }
                        }
                    }
                    if (!findDP) {
                        System.out.println("There is no Dependent with ID " + dP_ID);
                        System.out.println();
                    }
                }
            }
            if (choice == 12) {
                System.out.println();
                int claimChoice = 0;
                while (claimChoice < 1 || claimChoice > 2) {
                    System.out.println("1.Delete A Claim Of A Policy Holder");
                    System.out.println("2.Delete A Claim Of Dependent");
                    System.out.print("Enter Your Choice: ");
                    Scanner scanClaimChoice = new Scanner(System.in);
                    claimChoice = scanClaimChoice.nextInt();
                }
                System.out.println();

                boolean findClaim = false;
                if (claimChoice == 1) {
                    System.out.println(policyHolders);
                    String pH_ID = "";
                    while (pH_ID.length() != 11) {
                        System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        pH_ID = scanID.next();
                    }

                    boolean findPH = false;
                    Iterator<PolicyHolder> iterator = policyHolders.iterator();
                    while (iterator.hasNext()) {
                        PolicyHolder aPH = iterator.next();
                        if (aPH.getCustomerID().equals(pH_ID)) {
                            findPH = true;
                            System.out.println(aPH.getAll());
                            String claim_ID = "";
                            while (claim_ID.length() != 11) {
                                System.out.print("Enter Claim's ID ('F' + 10 number digits): ");
                                Scanner scanID = new Scanner(System.in);
                                claim_ID = scanID.next();
                            }

                            Iterator<Claim> iterator1 = claims.iterator();
                            while (iterator1.hasNext()) {
                                Claim aClaim = iterator1.next();
                                if (aClaim.getClaimID().equals(claim_ID)) {
                                    findClaim = true;
                                    aPH.delete(aClaim);
                                    claims.remove(aClaim);
                                    System.out.println("Dependent with ID " + claim_ID + " is deleted");
                                    System.out.println();
                                    break;
                                }
                            }
                            if (!findClaim) {
                                System.out.println("There is no Claim with ID " + claim_ID + " in this Policy Holder's Claim List");
                            }
                            System.out.println();
                            break;
                        }
                    }
                    if (!findPH) {
                        System.out.println("There is no Policy Holder with ID " + pH_ID);
                        System.out.println();
                    }
                }

                if (claimChoice == 2) {
                    System.out.println(dependents);
                    String dP_ID = "";
                    while (dP_ID.length() != 11) {
                        System.out.print("Enter Dependent's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        dP_ID = scanID.next();
                    }

                    boolean findDP = false;
                    Iterator<Dependent> iterator = dependents.iterator();
                    while (iterator.hasNext()) {
                        Dependent aDp = iterator.next();
                        if (aDp.getCustomerID().equals(dP_ID)) {
                            findDP = true;
                            System.out.println(aDp.getAll());
                            String claim_ID1 = "";
                            while (claim_ID1.length() != 11) {
                                System.out.print("Enter Claim's ID ('F' + 10 number digits): ");
                                Scanner scanID = new Scanner(System.in);
                                claim_ID1 = scanID.next();
                            }
                            Iterator<Claim> iterator1 = claims.iterator();
                            while (iterator1.hasNext()) {
                                Claim aClaim = iterator1.next();
                                if (aClaim.getClaimID().equals(claim_ID1)) {
                                    findClaim = true;
                                    aDp.delete(aClaim);
                                    claims.remove(aClaim);
                                    System.out.println("Claim with ID " + claim_ID1 + " is deleted");
                                    break;
                                }
                            }
                            if (!findClaim) {
                                System.out.println("There is no Claim with ID " + claim_ID1 + " in this Dependent's Claim List");
                                break;
                            }
                            System.out.println();
                            break;
                        }
                    }
                    if (!findDP) {
                        System.out.println("There is no Dependent with ID " + dP_ID);
                        System.out.println();
                    }
                }
            }
            if (choice == 13) {
                System.out.println();
                int claimChoice = 0;
                while (claimChoice < 1 || claimChoice > 2) {
                    System.out.println("1.Update A Claim Of A Policy Holder");
                    System.out.println("2.Update A Claim Of Dependent");
                    System.out.print("Enter Your Choice: ");
                    Scanner scanClaimChoice = new Scanner(System.in);
                    claimChoice = scanClaimChoice.nextInt();
                }
                System.out.println();

                boolean findClaim = false;
                if (claimChoice == 1) {
                    System.out.println(policyHolders);
                    String pH_ID = "";
                    while (pH_ID.length() != 11) {
                        System.out.print("Enter Policy Holder's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        pH_ID = scanID.next();
                    }

                    boolean findPH = false;
                    Iterator<PolicyHolder> iterator = policyHolders.iterator();
                    while (iterator.hasNext()) {
                        PolicyHolder aPH = iterator.next();
                        if (aPH.getCustomerID().equals(pH_ID)) {
                            findPH = true;
                            System.out.println(aPH.getAll());
                            String claim_ID = "";
                            while (claim_ID.length() != 11) {
                                System.out.print("Enter Claim's ID ('F' + 10 number digits): ");
                                Scanner scanID = new Scanner(System.in);
                                claim_ID = scanID.next();
                            }
                            for (Claim aClaim:aPH.getAll()) {
                                if (aClaim.getClaimID().equals(claim_ID)) {
                                    aPH.update(aClaim);
                                    System.out.println("Claim with ID " + claim_ID + " is updated with new information");
                                    findClaim = true;
                                    break;
                                }
                            }
                            if (!findClaim) {
                                System.out.println("There is no Claim with ID " + claim_ID + " in this Policy Holder's Claim List");
                            }
                            System.out.println();
                            break;
                        }
                    }
                    if (!findPH) {
                        System.out.println("There is no Policy Holder with ID " + pH_ID);
                        System.out.println();
                    }
                }

                if (claimChoice == 2) {
                    System.out.println(dependents);
                    String dP_ID = "";
                    while (dP_ID.length() != 11) {
                        System.out.print("Enter Dependent's ID ('C' + 10 number digits): ");
                        Scanner scanID = new Scanner(System.in);
                        dP_ID = scanID.next();
                    }

                    boolean findDP = false;
                    Iterator<Dependent> iterator = dependents.iterator();
                    while (iterator.hasNext()) {
                        Dependent aDp = iterator.next();
                        if (aDp.getCustomerID().equals(dP_ID)) {
                            findDP = true;
                            System.out.println(aDp.getAll());
                            String claim_ID1 = "";
                            while (claim_ID1.length() != 11) {
                                System.out.print("Enter Claim's ID ('F' + 10 number digits): ");
                                Scanner scanID = new Scanner(System.in);
                                claim_ID1 = scanID.next();
                            }

                            Iterator<Claim> iterator1 = claims.iterator();
                            while (iterator1.hasNext()) {
                                Claim aClaim = iterator1.next();
                                if (aClaim.getClaimID().equals(claim_ID1)) {
                                    aDp.update(aClaim);
                                    System.out.println("Claim with ID " + claim_ID1 + " is updated with new information");
                                    findClaim = true;
                                    break;
                                }
                            }
                            if (!findClaim) {
                                System.out.println("There is no Claim with ID " + claim_ID1 + " in this Dependent's Claim List");
                                break;
                            }
                            System.out.println();
                            break;
                        }
                    }
                    if (!findDP) {
                        System.out.println("There is no Dependent with ID " + dP_ID);
                        System.out.println();
                    }
                }
            }
            if (choice == 14) {
                System.out.println();
                fileWriting.writePolicyHolderIntoFile(policyHolders);
                fileWriting.writeClaimIntoFile(claims);
                fileWriting.writeDependentIntoFile(dependents);
                System.out.println("Thank you! Have A Good Day!");
                System.out.println();
                break;
            }
        }
    }
}
