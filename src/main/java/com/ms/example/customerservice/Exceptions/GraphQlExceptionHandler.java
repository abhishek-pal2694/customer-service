package com.ms.example.customerservice.Exceptions;

import graphql.GraphQLException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQlExceptionHandler {

    @ExceptionHandler(GraphQLException.class)
    public GraphQLException errorHandler(GraphQLException exception){
        System.out.println("exception handler working");
        return new GraphQLException(exception.getMessage());
    }
}
