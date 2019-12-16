package org;

class TestClass {
    public int compute(int param) {
        try {
            Thread.sleep(3000);
            System.out.println("compute compute!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param + 1000;
    }
}