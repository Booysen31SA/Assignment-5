package factory.finalizeRequest;

import domain.retirement.FinalizeRequest;

public class RemoveTeacherFactory {

    public static FinalizeRequest remove(int pasal){
        return new FinalizeRequest.Builder().setPasalNumber(pasal)
                                        .build();
    }
}
