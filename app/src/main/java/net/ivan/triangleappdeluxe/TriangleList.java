package net.ivan.triangleappdeluxe;

import java.util.ArrayList;

public class TriangleList {
    private static final ArrayList<Triangle> triangleList = new ArrayList<>();
    private static final int triangleListSize = 100;

    public static void addItem(Triangle t) {
        triangleList.add(t);

        if(triangleList.size() > triangleListSize) {
            triangleList.remove(triangleListSize);
        }
    }

    public static ArrayList<Triangle> getItems() {
        return triangleList;
    }

    public static void setItems(ArrayList<Triangle> list) {
        triangleList.clear();
        triangleList.addAll(list);
    }
}
