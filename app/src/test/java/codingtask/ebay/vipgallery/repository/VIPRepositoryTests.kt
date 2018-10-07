package codingtask.ebay.vipgallery.repository

import android.arch.lifecycle.MutableLiveData
import codingtask.ebay.vipgallery.RxImmediateSchedulerRule
import codingtask.ebay.vipgallery.data.api.GalleryAPI
import codingtask.ebay.vipgallery.data.model.VIP
import codingtask.ebay.vipgallery.data.repository.VIPRepository
import codingtask.ebay.vipgallery.util.ApiResponse
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

@RunWith(JUnit4::class)
class VIPRepositoryTests {

    @Rule
    @JvmField
    val rule = MockitoJUnit.rule()!!

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    private lateinit var vipapi: GalleryAPI

    private lateinit var vipRepository: VIPRepository

    @Before
    fun setup() {
        vipRepository = VIPRepository(vipapi)
    }

    @Test
    fun updateVipShouldReturnVip() {

        val vip = MutableLiveData<ApiResponse<VIP>>()

        Mockito.`when`(vipapi.getVIP("vipUrl")).thenReturn(vip)

        val result = vipRepository.updateVIP("vipUrl")

        result.observeForever {
            assertEquals(vip.value, it)
        }
    }
}