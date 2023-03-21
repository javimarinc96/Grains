import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Grains {
    
    BigInteger grainsOnSquare(final int square) {
        if(square < 1 || square > 64){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return new BigInteger("2").pow(square-1);
    }

    BigInteger grainsOnBoard() {
        return IntStream.rangeClosed(1, 64).parallel()
                .mapToObj(square -> grainsOnSquare(square)).reduce(BigInteger.ZERO, (BigInteger a, BigInteger b) -> a.add(b));

    }

}
