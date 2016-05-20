package test.pro.gamers;

import test.pro.ITException;

/**
 * Created by lekhr on 18.05.2016.
 */
public interface Gamer {

    public void makeMove(int i);

    public void setName(String name) throws ITException;

    public String getName();

}
