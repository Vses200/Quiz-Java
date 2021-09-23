/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quiz.*;

/**
 *
 * @author admin
 */
public class JUnitTests {
    
    
    @Test
    public void connection_test() {
        Jdbc conn = new Jdbc();
        assertNotNull(conn.con);
    }
    
    
    
    @Test
    public void fetchHighscore_test(){
        Highscore highscore = new Highscore();
        
        assertTrue(highscore.effected<=5);
    }
    
     @Test
    public void insertNewScore_test(){
        Jdbc conn = new Jdbc();
        conn.insert("Tanuja","60");
         assertEquals(conn.count,1);
       }
    
     @Test
    public void updateScore_test(){
        Jdbc conn = new Jdbc();
        conn.insert("Humpty", "1");
        conn.update("Humpty","2");
         assertTrue(conn.counts>=1);
    }
    
     @Test
    public void setName_test(){
        QuizHome quizhome = new QuizHome();
        quizhome.setName("Tanuja");
        assertEquals(quizhome.getName(),"Tanuja");
    }
     @Test
    public void falseGetName_test(){
        QuizHome quizhome = new QuizHome();
        quizhome.setName("Tanuja");
        String name= quizhome.getName();
         assertNotEquals(name,"Bastola");
    }
    
    @Test
    public void namePass_test(){
        QuizHome quizhome = new QuizHome();
        quizhome.setName("Tanuja");
        Rules rules = new Rules(quizhome.getName());
        assertEquals(quizhome.getName(),rules.username);
        
    }
     @Test
    public void FalseNamePass_test(){
        QuizHome quizhome = new QuizHome();
        quizhome.setName("Tanuja");
        Rules rules = new Rules(quizhome.getName());
        assertNotEquals("Bastola",rules.username);
        
    }
    
    @Test
    public void score_test(){
        Game game = new Game("Tanuja");
        game.score = 90;
        score dummyScore = game.passDummySccore(game.score);
        assertEquals(dummyScore.score, game.score);
        
    }
     @Test
    public void falseScore_test(){
        Game game = new Game("Tanuja");
        game.score = 90;
        score dummyScore = game.passDummySccore(game.score);
        assertNotEquals(dummyScore.score, 22);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
