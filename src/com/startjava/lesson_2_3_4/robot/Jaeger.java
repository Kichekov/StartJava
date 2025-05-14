package com.startjava.lesson_2_3_4.robot;

public class Jaeger {
    private String modelName;
    private String mark;
    private String origin;
    private float height;
    private float weight;
    private int speed;
    private int strength;
    private int armor;

    public Jaeger() {
    }

    public Jaeger(String modelName, String mark, String origin, float height, 
            float weight, int speed, int strength, int armor) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String drift() {
        return "Режим дрифт активирован";
    }

    public String move() {
        return "Проверка систем движения, произвожу тесты";
    }

    public String scanKaiju() {
        return "Произвожу сканирование Кайдзю";
    }

    public String useImpactGain() {
        return "Гидравлическое усиление систем движения активировано, произвожу тесты";
    }

    public String useMachineGuns() {
        return "Осуществляется тестовая стрельба по мишеням";
    }

    @Override
     public String toString() {
        return """
            Название модели: %s
            Семейство: %s
            Происхождение: %s
            Высота: %.2f м.
            Вес: %.3f т.
            Скорость: %d
            Сила: %d
            Броня: %d
            Дрифт: %s
            Движение: %s
            Сканер: %s
            Системы усиления: %s
            Пулеметы: %s
                """.formatted(
                    modelName, 
                    mark, 
                    origin, 
                    height, 
                    weight, 
                    speed,
                    strength,
                    armor,
                    drift(),
                    move(),
                    scanKaiju(),
                    useImpactGain(),
                    useMachineGuns()
                    );
    }
}
