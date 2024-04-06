import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("WELCOME TO INSURANCE CLAIMS MANAGEMENT PROGRAM");
        }


    }
}
