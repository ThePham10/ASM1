import java.io.IOException;
import java.util.ArrayList;
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
            System.out.println("5.View Dependents         | 12.Delete A Claim");
            System.out.println("6.Search Dependent        | 13.Update A Claim");
            System.out.println("7.Add A Dependent         | 14.Exit");
            System.out.print("Enter Your Choice: ");
            Scanner scanChoice = new Scanner(System.in);
            int choice = scanChoice.nextInt();
            while (choice < 0 || choice > 14) {
                System.out.print("Enter Your Choice: ");
                choice = scanChoice.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println("All Policy Holders In The System: \n");
                    System.out.println(policyHolders);
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    System.out.println("Thank you! Have a good day!");
                    break;
            }
        }


    }
}
