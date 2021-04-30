package chipyard

import freechips.rocketchip.config.{Config}

// ---------------------
// BOOM Configs
// ---------------------

class MinimalAbstractConfig extends Config(
  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new testchipip.WithBackingScratchpad ++                   // add mbus backing scratchpad
  new chipyard.config.AbstractConfig)

class Minimal32kBL2AbstractConfig extends Config(
  new freechips.rocketchip.subsystem.With32kBInclusiveCache ++       // use 32kB, 4-way Sifive L2 cache
  new chipyard.MinimalAbstractConfig)

class SuperMinimalAbstractConfig extends Config(
  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new freechips.rocketchip.subsystem.WithNoMMIOPort ++         
  new freechips.rocketchip.subsystem.WithNoSlavePort ++        
  new testchipip.WithBackingScratchpad ++                   // add mbus backing scratchpad
  new chipyard.config.AbstractConfig)

class MinimalSmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.MinimalAbstractConfig)

class MinimalSmallBoom16kBL132kBL2Config extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

// Doesn't work
class MinimalSmallBoom16kBL12W32kBL2Config extends Config(
  new boom.common.WithNSmall16kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom8kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall8kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom4kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall4kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom1kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall1kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL2Config extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)










class MinimalSmallBoom1kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 2) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 4) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 8) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 16) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)




class MinimalSmallBoom2kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 2) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 4) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 8) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 16) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)




class MinimalMediumBoom1kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 2) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 4) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 8) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 16) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)




class MinimalMediumBoom2kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 2) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 4) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 8) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 16) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)




class MinimalSmallBoom1kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 0) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 0) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 0) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 0) ++                          // Medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)












class WorkingMinimalSmallBoom1kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall1kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class SuperMinimalSmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.SuperMinimalAbstractConfig)

class MinimalMediumBoom8kBL1Config extends Config(
  new boom.common.WithNMediumBooms8kBL1(1) ++                          // medium boom config
  new chipyard.MinimalAbstractConfig)

class MinimalMediumBoom8kBL132kBL2Config extends Config(
  new boom.common.WithNMediumBooms8kBL1(1) ++                          // medium boom config
  new chipyard.Minimal32kBL2AbstractConfig)

class MinimalLargeBoom8kBL1Config extends Config(
  new boom.common.WithNLargeBooms8kBL1(1) ++                          // medium boom config
  new chipyard.MinimalAbstractConfig)

class SmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.config.AbstractConfig)

class MediumBoomConfig extends Config(
  new boom.common.WithNMediumBooms(1) ++                         // medium boom config
  new chipyard.config.AbstractConfig)

class LargeBoomConfig extends Config(
  new boom.common.WithNLargeBooms(1) ++                          // large boom config
  new chipyard.config.AbstractConfig)

class MegaBoomConfig extends Config(
  new boom.common.WithNMegaBooms(1) ++                           // mega boom config
  new chipyard.config.AbstractConfig)

class DualSmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(2) ++                          // 2 boom cores
  new chipyard.config.AbstractConfig)

class HwachaLargeBoomConfig extends Config(
  new chipyard.config.WithHwachaTest ++
  new hwacha.DefaultHwachaConfig ++                              // use Hwacha vector accelerator
  new boom.common.WithNLargeBooms(1) ++
  new chipyard.config.AbstractConfig)

class LoopbackNICLargeBoomConfig extends Config(
  new chipyard.harness.WithLoopbackNIC ++                        // drive NIC IOs with loopback
  new icenet.WithIceNIC ++                                       // build a NIC
  new boom.common.WithNLargeBooms(1) ++
  new chipyard.config.AbstractConfig)

class DromajoBoomConfig extends Config(
  new chipyard.harness.WithSimDromajoBridge ++                   // attach Dromajo
  new chipyard.config.WithTraceIO ++                             // enable the traceio
  new boom.common.WithNSmallBooms(1) ++
  new chipyard.config.AbstractConfig)
