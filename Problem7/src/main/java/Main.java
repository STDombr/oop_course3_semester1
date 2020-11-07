public class Main {

    public static void main(String[] args) {
        Lobby lobby = new Lobby();

        for (int i = 0; i < 5; i++)
            lobby.addPlayer(i);
    }
}
