package com.fse.tdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class OrderServiceTest {
    @Test void stubsLookupAndVerifiesSave() {
        OrderRepository repository = mock(OrderRepository.class);
        when(repository.existsByReference("ORD-1")).thenReturn(false);
        assertTrue(new OrderService(repository).create("ORD-1"));
        verify(repository).save("ORD-1");
    }
    @Test void doesNotSaveDuplicate() {
        OrderRepository repository = mock(OrderRepository.class);
        when(repository.existsByReference("ORD-1")).thenReturn(true);
        assertFalse(new OrderService(repository).create("ORD-1"));
        verify(repository, never()).save(anyString());
    }
}
