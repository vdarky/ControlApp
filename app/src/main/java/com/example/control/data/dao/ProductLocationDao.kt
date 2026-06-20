import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import com.example.control.auxiliar.ProductLocationWithLocation
import com.example.control.auxiliar.ProductLocationWithProduct


import com.example.control.data.entity.ProductLocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductLocationDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertStock(stock: ProductLocationEntity): Long

    @Update
    suspend fun updateStock(stock: ProductLocationEntity)

    @Delete
    suspend fun deleteStock(stock: ProductLocationEntity)

    @Query("SELECT * FROM product_location WHERE idProduct = :productId AND idLocation = :locationId LIMIT 1")
    suspend fun getStock(productId: Int, locationId: Int): ProductLocationEntity?

    @Query("SELECT COALESCE(SUM(quantity), 0) FROM product_location WHERE idProduct = :productId")
    suspend fun getTotalStockByProduct(productId: Int): Int

    @Query("SELECT COALESCE(quantity, 0) FROM product_location WHERE idProduct = :productId AND idLocation = :locationId")
    suspend fun getQuantityAtLocation(productId: Int, locationId: Int): Int

    @Query("""
        SELECT pl.*, l.name AS location_name 
        FROM product_location pl 
        INNER JOIN location l ON pl.idLocation = l.idLocation 
        WHERE pl.idProduct = :productId
    """)
    fun getStockDetailsByProduct(productId: Int): Flow<List<ProductLocationWithLocation>>

    @Query("""
        SELECT pl.*, p.name AS product_name, p.skuCode 
        FROM product_location pl 
        INNER JOIN product p ON pl.idProduct = p.idProduct 
        WHERE pl.idLocation = :locationId AND p.active = 1
    """)
    fun getStockDetailsByLocation(locationId: Int): Flow<List<ProductLocationWithProduct>>
}