package test;

import ca.unbc.cpsc101.gui.Board ; 
import javax.swing.SwingUtilities;

public class Test2
{

   public static void  setupStartConfiguration(Board aBoard)
      {
      emptyBoard(aBoard);
      final int [] pointNumber = { 24, 13, 8, 6} ;
      final int [] pointCount  = { 2, 5, 3, 5} ;
      for (int k=0;k<pointNumber.length;++k)
         {
         final int count = pointCount[k] ;
         final int blackPoint = pointNumber[k] ;
         final int whitePoint = 25 - blackPoint ;
         aBoard.setPointBlackCount(blackPoint,count);
         aBoard.setPointWhiteCount(whitePoint,count);
         }
      return;
      }

   public static void  emptyBoard(Board aBoard)
      {
      aBoard.setBarBlackCount(0);
      aBoard.setBarWhiteCount(0);
      for (int i=1;i<=24;++i)
         {
         aBoard.setPointBlackCount(i,0);
         }
      return ;
      }

   public static void setupFrame(Board aBoard)
      {
      javax.swing.JFrame frame = new javax.swing.JFrame("Test Backgammon Board");
      //frame.setSize(500,500);
      frame.setSize(1920,1080);
      frame.setLayout(null);
      frame.setBackground(new java.awt.Color(0.1f,0.1f,0.3f));
      frame.add(aBoard) ;
      frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      }

   public static void go()
      {
      Board aBoard = new Board() ;
      setupStartConfiguration(aBoard);
      setupFrame(aBoard) ;
      }

   public static void main(String [] args)
      {
      SwingUtilities.invokeLater(Test2::go);
      }
}
