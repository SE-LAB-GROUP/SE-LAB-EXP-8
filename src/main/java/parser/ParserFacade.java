package parser;

import Log.Log;
import codeGenerator.CodeGenerator;
import scanner.lexicalAnalyzer;
import scanner.token.Token;
import errorHandler.ErrorHandler;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ParserFacade {
    private static ParserFacade instance = null;
    private final Parser parser;
    private ParseTable parseTable;
    private final lexicalAnalyzer lexicalAnalyzer;
    private final CodeGenerator codeGenerator;

    public ParserFacade(java.util.Scanner scanner) {
        this.parser = new Parser();
        try {
            this.parseTable = new ParseTable(Files.readAllLines(Paths.get("src/main/resources/parseTable")).get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.lexicalAnalyzer = new lexicalAnalyzer(scanner);
        this.codeGenerator = new CodeGenerator();
    }

    public static ParserFacade getInstance(java.util.Scanner scanner) {
        if (instance == null) {
            instance = new ParserFacade(scanner);
        }
        return instance;
    }

    public void parse() {
        parser.initializeParser();
        Token lookAhead = lexicalAnalyzer.getNextToken();
        boolean finish = false;
        Action currentAction;
        while (!finish) {
            try {
                Log.print(lookAhead.toString() + "\t" + parser.getParsStack().peek());
                currentAction = parseTable.getActionTable(parser.getParsStack().peek(), lookAhead);
                switch (currentAction.action) {
                    case shift:
                        parser.shiftAction(currentAction);
                        lookAhead = lexicalAnalyzer.getNextToken();
                        break;
                    case reduce:
                        parser.reduceAction(currentAction, lookAhead, this.parseTable, this.codeGenerator);
                        break;
                    case accept:
                        finish = true;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!ErrorHandler.hasError) {
            codeGenerator.printMemory();
        }
    }
}