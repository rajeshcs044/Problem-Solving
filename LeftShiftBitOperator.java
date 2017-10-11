public class LeftShiftBitOperator
{
    public static void main(String[] args)
    {
        int[] input = { 1, 2, 3, 4, 5 };

        for (int i = 0; i < input.length; i++)
        {
            System.out.print(input[i]);
        }
        System.out.println();
        int[] b = leftShift(input, 4);

        for (int i = 0; i < input.length; i++)
        {
            System.out.print(b[i]);
        }
    }

    private static int[] leftShift(int[] input, int r)
    {
        for (int k = 0; k < r; k++)
        {
            int temp = input[0];
            for (int i = 0; i < input.length - 1; i++)
            {
                input[i] = input[i + 1];

            }
            input[input.length - 1] = temp;
        }
        return input;
    }
}

