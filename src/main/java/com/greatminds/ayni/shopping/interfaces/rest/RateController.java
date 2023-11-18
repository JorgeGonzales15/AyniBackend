package com.greatminds.ayni.shopping.interfaces.rest;

import com.greatminds.ayni.shopping.domain.model.queries.GetAllRatesQuery;
import com.greatminds.ayni.shopping.domain.model.queries.GetRateByIdQuery;
import com.greatminds.ayni.shopping.domain.services.RateCommandService;
import com.greatminds.ayni.shopping.domain.services.RateQueryService;
import com.greatminds.ayni.shopping.interfaces.rest.resources.CreateRateResource;
import com.greatminds.ayni.shopping.interfaces.rest.resources.RateResource;
import com.greatminds.ayni.shopping.interfaces.rest.transform.CreateRateCommandFromResourceAssembler;
import com.greatminds.ayni.shopping.interfaces.rest.transform.RateResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/rates", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rates", description = "Rates Management Endpoints")
public class RateController {
    private final RateQueryService rateQueryService;
    private final RateCommandService rateCommandService;

    public RateController(RateQueryService rateQueryService, RateCommandService rateCommandService) {
        this.rateQueryService = rateQueryService;
        this.rateCommandService = rateCommandService;
    }

    @PostMapping
    public ResponseEntity<RateResource> createRate(@RequestBody CreateRateResource resource){
        var createRateCommand = CreateRateCommandFromResourceAssembler.toCommandFromResource(resource);

        var rateId = rateCommandService.handle(createRateCommand);
        if(rateId == 0L){
            return ResponseEntity.badRequest().build();
        }

        var getRateIdByQuery = new GetRateByIdQuery(rateId);
        var rate = rateQueryService.handle(getRateIdByQuery);

        if(rate.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var rateResource = RateResourceFromEntityAssembler.toResourceFromEntity(rate.get());
        return new ResponseEntity<>(rateResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RateResource>> getAllRates(){
        var getAllRatesQuery = new GetAllRatesQuery();
        var rates = rateQueryService.handle(getAllRatesQuery);
        var ratesResources = rates.stream().map(RateResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(ratesResources);
    }

    @GetMapping("/{rateId}")
    public ResponseEntity<RateResource> getRateById(@PathVariable Long rateId){
        var getRateByIdQuery = new GetRateByIdQuery(rateId);
        var rate = rateQueryService.handle(getRateByIdQuery);
        if(rate.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var rateResource = RateResourceFromEntityAssembler.toResourceFromEntity(rate.get());
        return ResponseEntity.ok(rateResource);
    }
}
