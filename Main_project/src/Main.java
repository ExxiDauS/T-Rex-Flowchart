import java.util.*;
public class Main {
    public static void main(String[] args) {
        DatabaseConnect test = new DatabaseConnect();
        test.insertProblem("Travis have 5 baht give Scott 10 baht. How much money does Travis have left?"
                , "https://media.discordapp.net/attachments/1156324979705651381/1219016871291129936/178727725_1587958818057083_5793406160138075441_n.png?ex=6612ff6e&is=66008a6e&hm=8b6f9f4ed3f35687ce3cc0430d918d176c3a6e2b959c66c4b45697b4c3f85906&=&format=webp&quality=lossless&width=198&height=146"
                , null, "Travis so rich!!!");
        System.out.println(test.getProblem(6));
    }
}
