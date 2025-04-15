public class Wolf {
    private String wellKnownFact;
    private String gender;
    private String name;
    private int weight;
    private int age;
    private String color;
    
    public Wolf() {
    }

    public Wolf(String gender, String name, int weight, int age, String color) {
        this.gender = gender;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 8) {
            System.out.println("Некорректный возраст");
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWellKnownFact() {
        return wellKnownFact;
    }

    public void setWellKnownFact(String wellKnownFact) {
        this.wellKnownFact = wellKnownFact;
    }

    public void howl() {
        System.out.println(name + " воет.");
    }

    public void sit() {
        System.out.println(name + " сидит.");
    }

    public void eat() {
        System.out.println(name + " ест.");
    }

    public void hunt() {
        System.out.println(name + " охотится.");
    }

    public void sleep() {
        System.out.println(name + " спит.");
    }

    @Override
    public String toString() {
        return """
            Пол волка: %s.
            Имя волка: %s.
            Вес волка: %s кг.
            Возраст волка: %s года.
            Окрас волка: %s
            Интересный факт: %s
                """.formatted(
                    gender, 
                    name, 
                    weight, 
                    age, 
                    color, 
                    wellKnownFact);
    }
}