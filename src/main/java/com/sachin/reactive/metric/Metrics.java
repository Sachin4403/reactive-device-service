//package com.sachin.reactive.metric;
//
//
//import io.micrometer.core.instrument.Gauge;
//import io.micrometer.core.instrument.MeterRegistry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.management.Attribute;
//import javax.management.AttributeList;
//import javax.management.MBeanServer;
//import javax.management.ObjectName;
//import java.lang.management.ManagementFactory;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class Metrics {
//
//    private final static List<String> METRICS_NAME = Arrays.asList("process.cpu.load.custom","system.cpu.load.custom","process.system.load.average.custom");
//    private final static List<String> DESCRIPTION = Arrays.asList("process CPU Load","System CPU Load","System Average Load");
//
//
//    @Autowired
//    private MeterRegistry meterRegistry;
//
//    @PostConstruct
//    public void init() {
//        int i=0;
//        Gauge.builder(METRICS_NAME.get(i), this, Metrics::getProcessCpuLoad)
//                .baseUnit("%")
//                .description(DESCRIPTION.get(i))
//                .register(meterRegistry);
//        ++i;
//        Gauge.builder(METRICS_NAME.get(i), this, Metrics::getSystemCpuLoad)
//                .baseUnit("%")
//                .description(DESCRIPTION.get(i))
//                .register(meterRegistry);
//        ++i;
//        Gauge.builder(METRICS_NAME.get(i), this, Metrics::getSystemLoadAverage)
//                .baseUnit("%")
//                .description(DESCRIPTION.get(i))
//                .register(meterRegistry);
////        Gauge.builder("free.physical.memory.size.custom",this, Metrics::getFreePhysicalMemorySize)
////        .baseUnit("%")
////                .description("Free Physical Memory Size")
////                .register(meterRegistry);
////        Gauge.builder("free.physical.memory.size.custom",this, Metrics::getTotalPhysicalMemorySize)
////                .baseUnit("%")
////                .description("Total Physical Memory Size")
////                .register(meterRegistry);
////
//    }
//
////    public Double getTotalPhysicalMemorySize() {
////        return  getAttributeLoad("TotalPhysicalMemorySize");
////    }
////
////    public Double getFreePhysicalMemorySize() {
////        return  getAttributeLoad("FreePhysicalMemorySize");
////    }
//    public Double getProcessCpuLoad() {
//        return  getAttributeLoad("ProcessCpuLoad");
//    }
//    public Double getSystemCpuLoad() {
//        return  getAttributeLoad("SystemCpuLoad");
//    }
//
//    public Double getSystemLoadAverage() {
//        return  getAttributeLoad("SystemLoadAverage");
//    }
//
//    public Double getAttributeLoad(String attributeName) {
//        try {
//            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//            ObjectName name = ObjectName.getInstance("java.lang:type=OperatingSystem");
//            AttributeList list = mbs.getAttributes(name, new String[]{attributeName});
//
//            return Optional.ofNullable(list)
//                    .map(l -> l.isEmpty() ? null : l)
//                    .map(List::iterator)
//                    .map(Iterator::next)
//                    .map(Attribute.class::cast)
//                    .map(Attribute::getValue)
//                    .map(Double.class::cast)
//                    .orElse(null);
//
//        } catch (Exception ex) {
//            return null;
//        }
//    }
//}