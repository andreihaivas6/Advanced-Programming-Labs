public class Song extends Item {
    private String singer;

    public Song(String name, String path, String singer) throws Exception {
        super(name, path);
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + super.getName() + '\'' +
                ", path='" + super.getPath() + '\'' +
                ", singer='" + singer + '\'' +
                "}\n";
    }


    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
