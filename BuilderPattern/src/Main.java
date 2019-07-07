public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Computer computer = new Computer.ComputerBuilder("GigaByte", "Core I5").setGraphicsCard("RAEDON").setWebCam("8MP").build();
        System.out.println(computer);
    }
}


class Computer {
    private String motherBoard;
    private String processor;

    private String graphicsCard;
    private String webCam;

    @Override
    public String toString() {
        return "Computer{" +
                "motherBoard='" + motherBoard + '\'' +
                ", processor='" + processor + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", webCam='" + webCam + '\'' +
                '}';
    }

    private Computer(ComputerBuilder computerBuilder) {
        this.motherBoard = computerBuilder.motherBoard;
        this.processor = computerBuilder.processor;
        this.graphicsCard = computerBuilder.graphicsCard;
        this.webCam = computerBuilder.webCam;
    }


    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getWebCam() {
        return webCam;
    }

    public void setWebCam(String webCam) {
        this.webCam = webCam;
    }

    public static class ComputerBuilder {
        private String motherBoard;
        private String processor;

        private String graphicsCard;
        private String webCam;

        public ComputerBuilder(String motherBoard, String processor) {
            this.motherBoard = motherBoard;
            this.processor = processor;
        }

        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public ComputerBuilder setWebCam(String webCam) {
            this.webCam = webCam;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}