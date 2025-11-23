package Model.Expressions;

import Model.ADT.MyIDictionary;
import Model.Values.Value;

public class ValueExp implements Exp
{
    private final Value val;

    public ValueExp(Value val)
    {
        this.val = val;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> dict)
    {
        return this.val;
    }

    @Override
    public String toString()
    {
        return this.val.toString();
    }

    @Override
    public Exp deepCopy()
    {
        return new ValueExp(val.deepCopy());
    }
}
