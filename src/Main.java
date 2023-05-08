import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Figure> figures = Arrays.asList(
                new Figure("cube", "red", 1, false),
                new Figure("circle", "black", 1, true),
                new Figure("pyramid", "green", 2, true),
                new Figure("cube", "red", 2, false),
                new Figure("circle", "red", 3, false)
        );

        Map<Pair<String, String>, List<Figure>> sortedBodies = new HashMap<>();

        for (Figure figure : figures) {
            Pair<String, String> key = new Pair<>(figure.getShape(), figure.getColor());
            sortedBodies.computeIfAbsent(key, k -> new ArrayList<>()).add(figure);
        }

        // Осуществляем удаление дубликатов
        for (List<Figure> list : sortedBodies.values()) {
            Map<Pair<Integer, Boolean>, Figure> uniqueFigure = new HashMap<>();
            for (Figure figure : list) {
                Pair<Integer, Boolean> key = new Pair<>(figure.getWeight(), figure.isGlow());
                if (!uniqueFigure.containsKey(key) || !uniqueFigure.get(key).isGlow()) {
                    uniqueFigure.put(key, figure);
                }
            }
            list.clear();
            list.addAll(uniqueFigure.values());

            //Оставляем только одно светящиеся тело с самым большим весом
            Figure glowingFigure = null;
            int maxWeight = Integer.MIN_VALUE;
            for (Figure figure : list) {
                if (figure.isGlow() && figure.getWeight() > maxWeight) {
                    maxWeight = figure.getWeight();
                    glowingFigure = figure;
                }
            }
            Figure finalGlowingFigure = glowingFigure;
            list.removeIf(figure -> figure.isGlow() && figure != finalGlowingFigure);
        }
        System.out.println(sortedBodies);
    }
}