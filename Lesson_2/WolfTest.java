public class WolfTest {
    public static void main(String[] args) {
        Wolf bolto = new Wolf();
        bolto.setGender("Мужской");
        bolto.setName("Болто");
        bolto.setWeight(35);
        bolto.setAge(2);
        bolto.setColor("Серый с белыми пятнами");
        bolto.setWellKnownFact("""
            Болто — главный герой анимационного фильма «Балто»,
            выпущенного в 1995 году. Он является наполовину собакой, наполовину волком,
            который спас город Ном, доставив сыворотку во время эпидемии дифтерии."""
        );

        System.out.println("Пол волка: " + bolto.getGender() + ".");
        System.out.println("Имя волка: " + bolto.getName() + ".");
        System.out.println("Вес волка: " + bolto.getWeight() + " кг.");
        System.out.println("Возраст волка: " + bolto.getAge() + " года.");
        System.out.println("Окрас волка: " + bolto.getColor() + ".");
        System.out.println("Интересный факт: " + bolto.getWellKnownFact());

        bolto.howl();
        bolto.sit();
        bolto.eat();
        bolto.hunt();
        bolto.sleep();

        System.out.println();
        Wolf alfa = new Wolf("Мужской", "Альфа", 45, 2, "Cеро-бурый");
        alfa.setWellKnownFact("""
            В мультфильме «Альфа и Омега»
            волк Альфа изначально планировался как второстепенный персонаж,
            но благодаря харизматичному голосу Джастина Лонга роль была расширена,
            сделав Альфу одним из ключевых героев истории."""
        );
        alfa.print();

        alfa.howl();
        alfa.sit();
        alfa.eat();
        alfa.hunt();
        alfa.sleep();
    }
}
