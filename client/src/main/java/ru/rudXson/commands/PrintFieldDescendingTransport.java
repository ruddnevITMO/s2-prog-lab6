package ru.rudXson.commands;
;
import ru.rudXson.datatype.Flat;
import ru.rudXson.base.Client;
import ru.rudXson.datatype.Transport;
import ru.rudXson.requests.PrintFieldDescendingTransportRequest;
import ru.rudXson.responses.PrintFieldDescendingTransportResponse;

import java.io.IOException;
import java.util.Scanner;

public class PrintFieldDescendingTransport implements Command {
    public PrintFieldDescendingTransport(){

    }
    @Override
    public void execute(String[] args, Client client, boolean fromExecute, Scanner scanner) throws IOException {
        PrintFieldDescendingTransportResponse response = (PrintFieldDescendingTransportResponse) client.sendRequestGetResponse(new PrintFieldDescendingTransportRequest());

        for (Transport transport : response.transports) {
            System.out.println(transport);
        }
    }

    @Override
    public String getDescription() {
        return "Prints the transport field for all elements in descending order.";
    }
}
