package com.greatminds.ayni.shopping.interfaces.rest.transform;

import com.greatminds.ayni.shopping.domain.model.commands.CreateOrderCommand;
import com.greatminds.ayni.shopping.interfaces.rest.resources.CreateOrderResource;

public class CreateOrderCommandFromResourceAssembler {
    public static CreateOrderCommand toCommandFromResource(CreateOrderResource resource){
        return new CreateOrderCommand(resource.description(), resource.quantity(), resource.totalPrice(), resource.paymentMethod(), resource.status(), resource.saleId());
    }
}
