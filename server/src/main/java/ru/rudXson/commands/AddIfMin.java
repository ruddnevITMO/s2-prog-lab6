package ru.rudXson.commands;

import ru.rudXson.base.CLIController;
import ru.rudXson.datatype.Flat;
import ru.rudXson.requests.AddIfMinRequest;
import ru.rudXson.requests.AddRequest;
import ru.rudXson.requests.Request;
import ru.rudXson.responses.AddIfMinResponse;
import ru.rudXson.responses.Response;


public class AddIfMin implements Command {
    private final CLIController controller;

    public AddIfMin(CLIController controller) {
        this.controller = controller;
    }

    @Override
    public String getDescription() {
        return "Adds element if it is smaller than the smallest element of sorted array";
    }

    @Override
    public Response execute(Request req) {
        AddIfMinRequest request = (AddIfMinRequest) req;

        Object[] flatsArray = controller.getFlats().toArray();
        Flat minFlat = null;
        if (flatsArray.length > 0) {
            minFlat = (Flat) flatsArray[flatsArray.length - 1];
        } else {
            this.controller.addFlat(request.flat);
            return new AddIfMinResponse(null);
        }

        if (minFlat == null || request.flat.compareTo(minFlat) < 0) {
            this.controller.addFlat(request.flat);
            return new AddIfMinResponse(null);
        } else {
            return new AddIfMinResponse("Flat was not added to collection. Its value is greater than or equal to the minimum value in the collection.");
        }
    }
}