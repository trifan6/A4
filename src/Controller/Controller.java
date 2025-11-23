package Controller;

import Exceptions.EmptyStackException;
import Exceptions.MyException;
import Model.ADT.MyIStack;
import Model.PrgState;
import Model.Statements.IStmt;
import Repository.IRepository;

public class Controller
{
    private final IRepository repo;
    private boolean displayFlag = true;

    public Controller(IRepository repo)
    {
        this.repo = repo;
    }

    public void setDisplayFlag(boolean v)
    {
        this.displayFlag = v;
    }

    public PrgState oneStep(PrgState prgState) throws MyException
    {
        MyIStack<IStmt> stack = prgState.getExeStack();

        if(stack.isEmpty())
        {
            throw new EmptyStackException();
        }

        IStmt stmt = stack.pop();
        return stmt.execute(prgState);
    }

    public void allStep() throws MyException
    {
        PrgState prog = repo.getCrtPrg();
        repo.logPrgStateExec();

        if(displayFlag)
        {
            System.out.println("Initial state:\n" + prog.toString());
        }

        while(!prog.getExeStack().isEmpty())
        {
            oneStep(prog);
            repo.logPrgStateExec();

            if(displayFlag)
            {
                System.out.println("After step:\n" + prog.toString());
            }
        }

        if(displayFlag)
        {
            System.out.println("Final state:\n" + prog.toString());
        }
    }

}
