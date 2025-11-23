package Model.Expressions;

import Model.ADT.MyIDictionary;
import Exceptions.MyException;
import Model.Values.Value;

public interface Exp
{
    Value eval(MyIDictionary<String, Value> dict) throws MyException;

    Exp deepCopy();
}
