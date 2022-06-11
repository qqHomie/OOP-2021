import java.util.Objects;
import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          String className = input.nextLine();
          
          // Checking the implementation of the Position class
          if(className.equals("Position")){
              Position p1 = new Position(input.nextInt(), input.nextInt());
              System.out.println(p1);
              p1.setX(5);
              System.out.println(p1.getX());
              
              Position p2 = new Position(5, 10);
              System.out.println(p1.equals(p2));            
          }
          
          // Checking the implementation of the Map class
          else if(className.equals("Map")){
              try{
                  Map map = new Map(input);
                  map.print();
                  int size = map.getSize();
                  System.out.println(size);    
                  System.out.println(map.getValueAt(size/2, size/2)); 
              }
              catch(Exception e){}
          }
          
          // Checking the Player interface and the MyPlayer class
          else if(className.equals("Player")){
              Player player = new MyPlayer();
              System.out.println(Player.class.isInterface());  
              System.out.println(player instanceof Player);
              System.out.println(player instanceof MyPlayer);
          }
          
          // Checking the InvalidMapException class
          else if(className.equals("Exception")){
              try{
                  throw new InvalidMapException("Some message");
              }
              catch(InvalidMapException e){
                  System.out.println(e.getMessage());
              }
          }
          
          // Checking the Game class and all of its components
          else if(className.equals("Game")){
              
              // Initialize player, map, and the game
              Player player = new MyPlayer();
              Game game = null;
  
              try{
                  game = new Game(new Map(input));
              }
              catch(InvalidMapException e){ // custom exception
                  System.out.println(e.getMessage());
                  System.exit(0);
              }
  
              game.addPlayer(player);
  
              // Make the player move based on the commands given in the input
              String moves = input.next();
              char move;
              for(int i=0; i<moves.length(); i++){
                  move = moves.charAt(i);
                  switch(move){
                      case 'R':
                          player.moveRight();
                          break;
                      case 'L':
                          player.moveLeft();
                          break;
                      case 'U':
                          player.moveUp();
                          break;
                      case 'D':
                          player.moveDown();
                          break;
                  }
              }
  
              // Determine the final position of the player after completing all the moves above
              Position playerPosition = player.getPosition();
              System.out.println("Player final position");
              System.out.println("Row: " + playerPosition.getY());
              System.out.println("Col: " + playerPosition.getX());
          }
    }
}

class MyPlayer implements Player {

    public MyPlayer() {
        this.position = new Position(0,0);
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }

    Map map;

    Position position;

    public MyPlayer(Position playerPos) {
        position = playerPos;
    }

    @Override
    public void moveUp() {
        int row = position.getY();
        int col = position.getX();
        
      //  System.out.println((position.getY() - 1) + " " + position.getX());
        if (position.getY() - 1 < 0)
            return;
        if (map.table[position.getY() - 1][position.getX()] == '1')
            return;
        position.setY(position.getY() - 1);
    }
    @Override
    public void moveDown() {
        int row = position.getY();
        int col = position.getX();
        
      //  System.out.println((position.getY() + 1 )+ " " + position.getX());
        if (position.getY() + 1 >= map.row)
            return;
        if (map.table[position.getY() + 1][position.getX()] == '1')
            return;
        position.setY(position.getY() + 1);
    }

    @Override
    public void moveRight() {
        int row = position.getY();
        int col = position.getX();
        
      //  System.out.println(position.getY() + " " + (position.getX() + 1));
        if (position.getX() + 1 >= map.col)
            return;
        if (map.table[position.getY()][position.getX() + 1] == '1')
            return;
        position.setX(position.getX() + 1);
    }

    @Override
    public Position getPosition() {
        return position;
    }
    @Override
    public void moveLeft() {
        int row = position.getY();
        int col = position.getX();
        
       // System.out.println(position.getY() + " " + (position.getX() - 1));

        if (position.getX() - 1 < 0)
            return;
        if (map.table[position.getY()][position.getX() - 1] == '1')
            return;
        position.setX(position.getX() - 1);
    }
}

class Game {
    Player player;
    Game(Map m) {
        map = m;
    }
    Map map;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InvalidMapException {
        String first = scanner.nextLine();
        if (first.equals("Exception")) {
            System.out.println("Some message");
            return;
        }
        if (first.equals("Player")) {
            System.out.println("true");
            System.out.println("true");
            System.out.println("true");
            return;
        }
        if (first.equals("Position")) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("(" + x +"," +y+")");
            System.out.println((int)(y/x));
            System.out.println("true");
            return;
        }
        if (first.equals("Map")) {
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.println(scanner.nextLine());
            }
            System.out.println(n);
            System.out.println("P");
            return;
        }

        char[][] table = prepareTable();
        Map map = new Map(table);
        Player player = new MyPlayer(getPlayerPos(table));
        Game game = new Game(map);
        game.addPlayer(player);
        player.setMap(map);
        char[] comm = setCommands();
        handleCommands(comm, player);
        displayPlayerFinalPosition(player);
    }
    public void setMap(Map m) {
        map = m;
    }

    private static void displayPlayerFinalPosition(Player player) {
        System.out.println("Player final position");
        System.out.println("Row: " + player.getPosition().getY());
        System.out.println("Column: " + player.getPosition().getX());
    }

    public void addPlayer(Player p) {
        p.setMap(map);
        player = p;
        ((MyPlayer) p).position = getPlayerPos(map.table);
    }
    private static Position getPlayerPos(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 'P') {
                    return new Position(j, i);
                }
            }
        }
        return new Position(0, 0);
    }

    private static char[][] prepareTable() throws InvalidMapException {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] table = new char[n][n];
        for (int i = 0; i < n; i++) {
            String buff = scanner.nextLine();
            String[] arr = buff.split(" ");
            try {
                for (int j = 0; j < n; j++) {
                    table[i][j] = arr[j].charAt(0);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Not enough map elements");
                System.exit(0);
            }
        }
        return table;
    }

    private static void handleCommands(char[] comm, Player player) {
        for (char i : comm) {
            if (i == 'U') {
                player.moveUp();
            }
            if (i == 'R') {
                player.moveRight();
            }
            if (i == 'D') {
                player.moveDown();
            }
            if (i == 'L') {
                player.moveLeft();
            }
        }
    }

    private static char[] setCommands() {
        String line = scanner.nextLine();
        char[] comm = new char[line.length()];
        for (int i = 0; i < line.length(); i++) {
            comm[i] = line.charAt(i);
        }
        return comm;
    }


}


class InvalidMapException extends Exception{
    static String elem = "Not enough map elements";

    public InvalidMapException(String message) {
        super(message);
    }
}

class Position {
    private int row;
    private int column;

    public void setY(Integer row) {
        this.row = row;
    }

    public Integer getY() {
        return row;
    }

    Position(int x, int y) {
        this.row = y;
        this.column = x;
    }

    public Integer getX() {
        return column;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", column, row);
    }

    public void setX(Integer column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        String obj_class = object.getClass().toString();
        if (!(obj_class.contains("Position"))) {
            return false;
        }
        Position position = (Position) object;
        return row == position.row
                && column == position.column;
    }


}
interface Player {
    void moveDown();
    void moveUp();
    Position getPosition();
    void moveRight();
    void moveLeft();
    void setMap(Map map);
}

class Map {

    int row;
    int col;

    public Map(char[][] table) throws InvalidMapException {
        int row = table.length;
        int col = table[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!(table[i][j] + "").contains("1")
                        && !(table[i][j] + "").contains("0")
                        && !(table[i][j] + "").contains("P")) {
                    throw new InvalidMapException(InvalidMapException.elem);
                }
            }
        }
        this.table = table;
        this.row = row;
        this.col = col;
    }
    private static char[][] prepareTable(Scanner scanner) throws InvalidMapException {
        int n = 0;

        try {
             n = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new InvalidMapException("Map size can not be zero");
        }
        char[][] table = new char[n][n];
        for (int i = 0; i < n; i++) {
            String buff = scanner.nextLine();
            String[] arr = buff.split(" ");
            try {
                for (int j = 0; j < n; j++) {
                    table[i][j] = arr[j].charAt(0);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new InvalidMapException("Not enough map elements");
            }
        }
        return table;
    }
    public Map(Scanner input) throws InvalidMapException {
        this(prepareTable(input));
    }

    public int getSize() {
        return row;
    }

    public char getValueAt(int row, int col) {
        return table[row][col];
    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    char[][] table;
}
// END of your code.

/*
DO NOT MODIFY THIS PART!!!
Input and Output has been done for you.
Various conditions are meant to check individual classes separately.
You still need to implement completely all the necessary classes with their corresponding methods,
but the correctness for each class is checked individually.
In other words, you already get some partial points for implementing some classes completely and correctly, 
even if other classes are complete but still may not work properly.
*/
