package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String AccessModifier=null;
        String ReturnType;
        String MethodName;
        StringTokenizer st =new StringTokenizer(signatureString, "()");
        String [] arr= new String[2];
        int i = 0;
        while(st.hasMoreTokens())
            arr[i++] = st.nextToken();
            String[] left = arr[0].split(" ");
            boolean modificator = left.length > 2;
            i = 0;
        if (modificator)
            AccessModifier = left[i++];
            ReturnType = left[i++];
            MethodName = left[i];
        MethodSignature res = new MethodSignature(MethodName, getArgs(arr[1]));
        res.setAccessModifier(AccessModifier);
        res.setReturnType(ReturnType);

        return res;
    }

    private List<MethodSignature.Argument> getArgs(String argsString) {
        List<String> args;
        List<MethodSignature.Argument> res = new ArrayList<>();

        if (argsString != null)
            args = List.of(argsString.split(", "));
        else
            return res;
        for (String arg : args) {
            String[] argArr = arg.split(" ");
            res.add(new MethodSignature.Argument(argArr[0], argArr[1]));
        }
        return res;
    }
}