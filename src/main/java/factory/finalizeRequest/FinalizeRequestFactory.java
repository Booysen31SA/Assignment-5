package factory.finalizeRequest;

import domain.retirement.FinalizeRequest;

public class FinalizeRequestFactory {

    public static FinalizeRequest Update(int pasal, String id, double pay, String status){
        return new FinalizeRequest.Builder().setPasalNumber(pasal)
                .setId(id)
                .setPayout(pay)
                .setStatus(status).build();
    }
}
