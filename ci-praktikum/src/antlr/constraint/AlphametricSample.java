package antlr.constraint;

import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.variables.Operator;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;

import java.util.HashMap;
import java.util.Map;

import static choco.Choco.*;
import static java.lang.System.arraycopy;

/**
 * User: Alex
 * Date: 17.05.13
 * Time: 16:26
 */
public class AlphametricSample {
    /**
     * Field inputTerm1 is the first term.
     */
    private final String inputTerm1;
    /**
     * Field inputTerm2 is the second term.
     */
    private final String inputTerm2;
    /**
     * Field inputResult is the expected result.
     */
    private final String inputResult;
    /**
     * Field allUniqueCharacters contains all used characters.
     */
    private final String allUniqueCharacters;
    /**
     * Field intVarMap holds all needed variables.
     */
    private final Map<String, IntegerVariable> intVarMap = new HashMap<String, IntegerVariable>();
    /**
     * Field model holds structures for a model of constraint programming
     */
    private final CPModel model = new CPModel();
    /**
     * Field solver for the model.
     */
    private final CPSolver solver = new CPSolver();

    /**
     * Method removeDuplicateChar creates a string with a containing characters
     */
    private static String removeDuplicateChar(String s) {
        StringBuffer result = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); i++) {
            String next = s.substring(i, i + 1);
            if (-1 == result.indexOf(next)) {
                result.append(next);
            }
        }
        return result.toString();
    }

    /**
     * Method prepareIntegerVariables creates all needed variables
     */
    private void prepareIntegerVariables() {
        for (int i = 0; i < allUniqueCharacters.length(); i++) {
            String variable = allUniqueCharacters.substring(i, i + 1);
            intVarMap.put(variable, makeIntVar(variable, 0, 9));
        }
    }

    /**
     * Method prepareModel defines the constraints
     */
    private void prepareModel() {
// 1st Constraint - the first digits are not allowed to be zero)
        model.addConstraints(neq(intVarMap.get(inputTerm1.substring(0, 1)), 0));
        model.addConstraints(neq(intVarMap.get(inputTerm2.substring(0, 1)), 0));
// 2nd Constraint - all characters have to be different)
        IntegerVariable[] intVarArray = new IntegerVariable[allUniqueCharacters.length()];
        for (int i = 0; i < allUniqueCharacters.length(); i++) {
            intVarArray[i] = intVarMap.get(allUniqueCharacters.substring(i, i + 1));
        }
        model.addConstraint(allDifferent(intVarArray));
// 3rd Constraint - the "term1 + term2 = result" equation)
        IntegerExpressionVariable firstExpression = createExpression(inputTerm1);
        IntegerExpressionVariable secondExpression = createExpression(inputTerm2);
        IntegerExpressionVariable resultExpression = createExpression(inputResult);
        model.addConstraints(eq(plus(firstExpression, secondExpression), resultExpression));
    }

    /**
     * Method createExpression creates the variables from the input strings
     */
    private IntegerExpressionVariable createExpression(String valueString) {
// Creates the scalar product of the variables
        int[] lc = new int[valueString.length()];
        IntegerVariable[] first = new IntegerVariable[valueString.length()];
        for (int i = 0; i < valueString.length(); i++) {
            first[i] = intVarMap.get(valueString.substring(i, i + 1));
            lc[i] = (int) Math.pow(10, valueString.length() - i - 1);
        }
        IntegerVariable[] tmp = new IntegerVariable[lc.length + first.length];
        for (int i = 0; i < lc.length; i++) {
            tmp[i] = constant(lc[i]);
        }
        arraycopy(first, 0, tmp, lc.length, first.length);
        return new IntegerExpressionVariable(null, Operator.SCALAR, tmp);
    }

    /**
     * Method printResult needed just for output of input and results
     */
    private void printResult() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" TASK : ");
        buffer.append(inputTerm1);
        buffer.append(" + ");
        buffer.append(inputTerm2);
        buffer.append(" = ");
        buffer.append(inputResult);
        buffer.append('\n');
        buffer.append(" SOLUTION : ");
        buffer.append(solver.solutionToString());
        buffer.append('\n');
        buffer.append(" RESULT : ");
        appendNumber(buffer, inputTerm1);
        buffer.append(" + ");
        appendNumber(buffer, inputTerm2);
        buffer.append(" = ");
        appendNumber(buffer, inputResult);
        System.out.println(buffer);
    }

    /**
     * Method appendNumber is a helper for output method printResult()
     */
    private void appendNumber(StringBuffer buffer, String text) {
        for (int i = 0; i < text.length(); i++) {
            String variable = text.substring(i, i + 1);
            buffer.append(String.format("%d", solver.getVar(intVarMap.get(variable))                                 .getVal()));
        }
    }

    /**
     * Constructor for AlphametricSample the strings should not be empty
     */
    public AlphametricSample(String term1, String term2, String result) {
        this.inputTerm1 = term1.toUpperCase();
        this.inputTerm2 = term2.toUpperCase();
        this.inputResult = result.toUpperCase();
        this.allUniqueCharacters = removeDuplicateChar(term1 + term2 + result);
    }

    /**
     * Method run does all the work
     */
    public void run() {
        prepareIntegerVariables();
        prepareModel();
        solver.read(model);
        solver.solve();
        printResult();
    }

    /**
     * Method main contains two test cases
     */
    public static void main(String[] args) {
        System.out.println("First sample:");
        new AlphametricSample("CRACK", "HACK", "ERROR").run();
        System.out.println("\nSecond sample:");
        new AlphametricSample("SEND", "MORE", "MONEY").run();
    }
}
