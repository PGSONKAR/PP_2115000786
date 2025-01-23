class Pens {
    public static void main(String[] args) {
        int pen = 14;
        int students = 3;
        int non_distributed_pens = 14 % 3;
        int pens = pen - non_distributed_pens;
        int pensPerStudent = pens / students;
        System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + non_distributed_pens);
    }    
}