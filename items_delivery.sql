-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2020 at 11:19 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `items_delivery`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `phone_number` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `firstname`, `lastname`, `phone_number`) VALUES
(1, 'จิตติณณ์', 'จินดานรเศรษฐ์', '0802000007'),
(2, 'ณัฐณิชา', 'คงสุนทร', '0860000009'),
(3, 'ปิยทัช', 'สุลา', '0940000000'),
(4, 'พิมพ์ลภัส', 'ตันธนกุล', '0810000004'),
(5, 'นิธิวัฒน์', 'อภัยกาวี', '0611040082'),
(6, 'ชัยมงคล', 'พงษ์งามเกียรติ', '0611040160'),
(7, 'รินลณี', 'วัชรนิมมานกุล', '0611040163'),
(8, 'สุรยุทธ์', 'บุญคล้าย', '0611040625'),
(9, 'เขมชาติ', 'เสาวหงษ์', '0611040157'),
(10, 'กัญญาณัฐ', 'อินทรโชติ', '0611040273'),
(11, 'สมหมาย', 'ณ จุดหมาย', '0802005000'),
(12, 'สมศักดิ์', 'สมยศ', '0868994325'),
(13, 'ธนกฤต', 'โลจันทร์ติ', '0611040277'),
(14, 'นิรัติศัย', 'คงศักดิ์', '0611040606');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `unit` tinytext NOT NULL,
  `description` text DEFAULT NULL,
  `quantity` int(10) UNSIGNED DEFAULT 0,
  `required` int(10) UNSIGNED DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `name`, `unit`, `description`, `quantity`, `required`) VALUES
(1, 'ROUTER (เราเตอร์) XIAOMI MI AIO T ROUTER AX3600 (29010) [XMI-DVB4251GL] - BLACK', 'ชิ้น', '7 Antennas\r\n1 AIoT Antenna 802.11b/g/n\r\nTransfer speeds 2402Mbps\r\nAutomatically discover new devices', 1, 1),
(2, 'ROUTER (เราเตอร์) LINKSYS EA7500S DUAL BAND AC1900 GIGABIT PORT MU MIMO', 'ชิ้น', 'INTERFACE : IEEE 802.11 a/b/g/n/ac\r\nLAN : 4 X 10/100/1000 Mbps PORTS\r\nWAN : 1 X 10/100/1000 Mbps PORT', 7, 5),
(3, 'ROUTER (เราเตอร์) LINKSYS ROUTER (EA8100) DUAL BAND AC2600 GIGABIT PORT MU MIMO', 'ชิ้น', 'INTERFACE : IEEE 802.11 b/g/a/ac/g\r\nLAN : 4 X 10/100/1000 Mbps PORTS\r\nWAN : 1 X 10/100/1000 Mbps PORT', 8, 4),
(4, 'ROUTER (เราเตอร์) ASUS RT-AX82U DUAL BAND AX5400 WIFI6 RGB', 'ชิ้น', 'INTERFACE : IEEE 802.11 a/b/g/n/ac/ax\r\nLAN : 4 X 10/100/1000 Mbps PORTS\r\nWAN : 1 X 10/100/1000 Mbps PORTS\r\n1 x USB 3.2 GEN 1', 2, 0),
(5, 'ROUTER (เราเตอร์) TENDA AC21 AC2100 DUAL BAND GIGABIT PORT', 'ชิ้น', 'INTERFACE : IEEE 802.11 n/g/b/ac\r\nLAN : 3 X 10/100/1000 Mbps PORTS\r\nWAN : 1 X 10/100/1000 Mbps PORT', 9, 0),
(6, 'ROUTER (เราเตอร์) ASUS RT-AC59U V2 - AC1500 DUAL BAND GIGABIT WIFI ROUTER WITH MU-MIMO/AIMESH', 'ชิ้น', '• AiMesh Supported - Connect to other compatible ASUS routers to create a powerful and flexible whole-home Wi-Fi network\r\n• 600 Mbps (2.4GHz) and 867 Mbps (5GHz) for fast wireless performance.\r\n• 4 x Gigabit LAN port Speeds can be up to 10× faster than 100 Base-T Ethernet connections.\r\n• 1 x USB 2.0 port ASUS AiDisk offers network file sharing both locally and remotely.\r\n• Enjoy the ASUSWRT dashboard UI for easy setup and manage your router.\r\n• Improved coverage and multi-device performance with four external antennas.', 14, 3),
(7, 'ROUTER (เราเตอร์) ASUS RT-AX3000 AX3000 DUAL BAND WI-FI 6 (802.11ax)', 'ชิ้น', 'Next-Gen Wi-Fi Standard - Supporting the latest Wi-Fi standard 802.11AX (Wi-Fi 6) and 160MHz bandwidth for better capacity and efficiency.\r\nUltra-fast Wi-Fi Speed – RT-AX3000 supports 160MHz bandwidth and 1024-QAM for dramatically faster wireless connections. With a total networking speed of about 3000Mbps — 574 Mbps on the 2.4GHz band and 2402 Mbps on the 5GHz band.\r\nIncrease Capacity and Efficiency – Supporting not only MU-MIMO but also OFDMA technique to efficiently allocate channels, communicate with multiple devices simultaneously\r\nCommercial-grade Security - lifetime free AiProtection, powered by Trend Micro™, blocks internet security threats for all your connected smart devices.\r\nBetter Partner with Mesh System - Compatible with ASUS AiMesh Wi Fi system for seamless whole-home coverage.', 6, 2),
(8, 'LAN CABLE (สายแลน) POWERSYNC CAT.7 HIGHSPEED 5.0 METER (L7HB0020) (ULTRA-SLIM FLAT TYPE)', 'ชิ้น', 'LAN CABLE 5.0 METER', 18, 5),
(9, 'LAN CABLE (สายแลน) POWERSYNC CAT.7 HIGHSPEED 3.0 METER (L7HB0020) (ULTRA-SLIM FLAT TYPE)', 'ชิ้น', 'LAN CABLE 3.0 METER', 9, 6),
(10, 'LAN CABLE (สายแลน) POWERSYNC CAT.7 HIGHSPEED 2.0 METER (L7HB0020) (ULTRA-SLIM FLAT TYPE)', 'ชิ้น', 'LAN CABLE 2.0 METER', 17, 2),
(11, 'LAN CABLE (สายแลน) LINK US-9106OUT-1 CAT6 UTP, PE OUTDOOR W/CROSS FILLER (DOUBLE) (100M) - BLACK)', 'ชิ้น', 'LENGH : 100 M', 5, 0),
(12, 'LAN CABLE (สายแลน) LINK US-9106OUT CAT6 UTP, PE OUTDOOR W/CROSS FILLER (DOUBLE) (305M) - BLACK', 'ชิ้น', 'LENGH : 305 M', 0, 0),
(13, 'LAN CABLE (สายแลน) LINK US-9116 CAT6 UTP ULTRA W/CROSS FILLER, 23AWG, CMR (305M) - WHITE', 'ชิ้น', 'LENGH : 305 M', 0, 0),
(14, 'LAN CABLE (สายแลน) BELKIN CAT6 RJ-45 BLUE 10M (A3L980bt10MBLUS)', 'ชิ้น', 'LAN CABLE 10 METER', 2, 11),
(15, 'LAN CABLE (สายแลน) BELKIN CAT6 RJ-45 BLUE 2M (A3L980bt02MBLUS)', 'ชิ้น', 'Lenght : 2M', 7, 16),
(16, 'LAN CABLE (สายแลน) BELKIN CAT6 RJ-45 BLUE 15M (A3L980bt15MBLUS)', 'ชิ้น', 'LAN CABLE 15.0 METER', 0, 4),
(17, 'LAN CABLE (สายแลน) POWER SYNC CAT 6 NETWORK ETHERNET FLAT CABLE (DARK BLUE) C65B10FLB 10 METER', 'ชิ้น', 'LAN CABLE 10 METER', 0, 0),
(18, 'LAN CABLE (สายแลน) POWER SYNC CAT 6 NETWORK ETHERNET FLAT CABLE (DARK BLUE) C65B3FLB 3.0 METER', 'ชิ้น', 'LAN CABLE 3.0 METER', 0, 0),
(19, 'LAN CABLE (สายแลน) POWER SYNC CAT 6 NETWORK ETHERNET FLAT CABLE (DARK BLUE) C65B1FLB 1.0 METER', 'ชิ้น', 'LAN CABLE 1.0 METER', 0, 0),
(20, 'POWER LINE (เพาเวอร์ไลน์) TP-LINK ACCESS POINT (RE205) RANGE EXTENDER AC750', 'ชิ้น', 'INTERFACE : IEEE 802.11 ac/n/g/b/a\r\nLAN : 1 X 10/100 Mbps PORT', 3, 0),
(21, 'POWER LINE (เพาเวอร์ไลน์) TP-LINK TL-WPA8630-KIT AC1200 AC1350 WI-FI', 'ชิ้น', 'INTERFACE : IEEE 802.11 b/g/n/a/ac', 0, 0),
(22, 'POWER LINE (เพาเวอร์ไลน์) TP-LINK TL-WPA4220-KIT N300 AV500 WI-FI', 'ชิ้น', 'INTERFACE : IEEE 802.11 u/b/g/n\r\nLAN : 2 X 10/100 Mbps PORTS', 0, 0),
(23, 'USB TO ETHERNET ADAPTER (อุปกรณ์แปลงสัญญาณ) UGREEN 2.0 TO LAN 10/100 (ABS CASE) [30305] (BLACK)', 'ชิ้น', 'USB 2.0 TO LAN 10/100 Mbps', 0, 0),
(24, 'USB TO ETHERNET ADAPTER (อุปกรณ์แปลงสัญญาณ) LINKSYS USB 3.0 GIGABIT ETHERNET ADAPTER (USB3GIG)', 'ชิ้น', 'INTERFACE : USB 3.0 TO GIGABIT PORT', 0, 0),
(25, 'USB TO ETHERNET ADAPTER (อุปกรณ์แปลงสัญญาณ) UGREEN TYPE-C TO LAN GIGABIT [50307]', 'ชิ้น', 'LAN : 1 X 10/100/1000 Mbps WITH USB PORT', 0, 0),
(26, 'USB TO ETHERNET ADAPTER (อุปกรณ์แปลงสัญญาณ) UGREEN USB 3.0 TO LAN 10/100/1000 Mbps (ABS) [20255]', 'ชิ้น', 'LAN : 1 X 10/100 Mbps WITH USB PORT', 0, 0),
(27, 'MESH WI-FI (เครือข่ายไวไฟ) ASUS ROUTER ZENWIFI AC CT8 (PACK 2)', 'ชิ้น', 'INTERFACE : IEEE 802.11 ac/a/b/g/n\r\nLAN : 3 X 10/100/1000 Mbps PORTS\r\nWAN : 1 X 10/100/1000 Mbps PORTS', 2, 1),
(28, 'MESH WI-FI (เครือข่ายไวไฟ) TP-LINK DECO X20 - AX1800 WHOLE HOME MESH WI-FI 6 SYSTEM (PACK 2)', 'ชิ้น', '• Faster Connections: Wi-Fi 6 speeds up to 1,800 Mbps—1,201 Mbps on 5 GHz and 574 Mbps on 2.4 GHz.\r\n• Connect More Devices: OFDMA and MU-MIMO technology quadruple capacity to enable simultaneous transmission to more devices.\r\n• Boosted Seamless Coverage: Achieve seamless whole home coverage with a clearer and stronger whole home Wi-Fi signal generated by Wi-Fi 6.\r\n• Ultra-Low Latency: Greater reduction in latency enables more responsive gaming and video chatting.\r\n• One Unified Network: Multiple units form a whole-home network that auto-selects the best connection as you move around your home.\r\n• Total Security: WPA3 encryption and TP-Link HomeCare™ provide personalized features, including Parental Controls, Antivirus, and Quality of Service (QoS) to ensure a safer online experience.\r\n• Setup Made Easier Than Ever: The Deco app walks you through setup step-by-step.', 10, 7),
(29, 'MESH WI-FI (เครือข่ายไวไฟ) ASUS ZENWIFI AX (XT8) - TRI BAND 2 PACK MESH WI-FI AX6600 (BLACK)', 'ชิ้น', 'The ZenWiFi AX system consists of a pair of ASUS AX6600 WiFi 6 routers, featuring unique technologies that give you superfast, reliable and secure WiFi connections.', 3, 0),
(30, 'MESH WI-FI (เครือข่ายไวไฟ) TP-LINK DECO X60 - AX3000 WHOLE HOME MESH WIFI SYSTEM (PACK 3)', 'ชิ้น', '• Incredible Wi-Fi 6 Speed & Coverage: Cover up to 7,000 sq. ft. in high-performance 3 Gbps (3000 Mbps) speeds, perfect for 4K/8K streaming, intense online gaming, and more throughout your whole home.†\r\n• Connect up to 150 Devices: Revolutionary OFDMA and MU-MIMO technology lets your router communicate more data to more devices.△\r\n• Boosted Seamless Coverage: Achieve seamless whole-home coverage with a clearer and stronger whole-home WiFi signal generated by Wi-Fi 6.‡\r\n• Ultra-Low Latency: Greater reduction in latency enables more responsive gaming and video chatting.\r\n• One Unified Network: Multiple units form a whole-home network that auto-selects the best connection as you move around your home.\r\n• Total Security: WPA3 encryption and TP-Link HomeCareTM provide personalized features, including Parental Controls, Antivirus, and Quality of Service (QoS) to ensure a safer online experience.§\r\n• Setup Made Easier Than Ever: The Deco app walks you through the setup step-by-step.', 9, 5),
(31, 'SWITCH (สวิตซ์) CISCO 24 PORTS SG220-26P-K9-EU GIGABIT PORT WITH 2 PORTS SFP', 'ชิ้น', 'LAN : 24 X 10/100 Mbps PORTS + 2 x combo Gigabit SFP', 7, 0),
(32, 'SWITCH (สวิตซ์) ARUBA INSTANT ON 1930 24 PORTS 24G CLASS4 PoE 4SFP/SFP+ 370W (JL684A)', 'ชิ้น', 'LAN : 24 X 10/100/1000 Mbps PORTS', 5, 4),
(33, 'SWITCH (สวิตซ์) CISCO Catalyst 2960-X 24 GigE, 4 x 1G SFP, LAN Base (WS-C2960X-24TS-L)', 'ชิ้น', 'Switch - 24 ports - Managed - stackable\r\nGigabit Ethernet\r\n24 x 10/100/1000 + 4 x Gigabit SFP', 7, 1),
(34, 'WI-FI RANGE EXTENDER (อุปกรณ์ขยายสัญญาณ) TP-LINK RE505X RANGE EXTENDER AC1200 WIFI 6', 'ชิ้น', 'INTERFACE : IEEE 802.11a/n/ac/ax', 0, 0),
(35, 'WI-FI RANGE EXTENDER (อุปกรณ์ขยายสัญญาณ) TP-LINK RE650 AC2600 WI-FI RANGE EXTENDER', 'ชิ้น', 'INTERFACE : IEEE 802.11 ac/b/g/n\r\nLAN : 1 X 10/100/1000 Mbps PORT', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `item_export`
--

CREATE TABLE `item_export` (
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `export_quantity` int(10) UNSIGNED DEFAULT NULL,
  `export_datetime` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item_export`
--

INSERT INTO `item_export` (`order_id`, `item_id`, `export_quantity`, `export_datetime`) VALUES
(1, 1, 1, '2020-11-12 08:40:06'),
(1, 2, 1, '2020-11-12 08:40:06'),
(1, 3, 1, '2020-11-12 08:40:06'),
(1, 10, 5, '2020-11-12 08:40:06'),
(2, 1, 3, '2020-11-12 08:43:49'),
(2, 2, 1, '2020-11-12 08:43:49'),
(2, 10, 3, '2020-11-12 08:43:49'),
(3, 2, 1, '2020-11-12 09:50:41'),
(3, 3, 1, '2020-11-12 09:50:41'),
(3, 4, 1, '2020-11-12 09:50:41'),
(3, 10, 2, '2020-11-12 09:50:41'),
(6, 10, 5, '2020-11-13 06:03:31'),
(7, 6, 6, '2020-11-13 09:55:29'),
(12, 2, 1, '2020-11-13 07:19:37'),
(12, 3, 1, '2020-11-13 07:19:37'),
(25, 7, 1, '2020-11-17 04:55:22'),
(25, 14, 3, '2020-11-17 04:55:22'),
(25, 27, 2, '2020-11-17 04:55:22'),
(25, 29, 2, '2020-11-17 04:55:22'),
(26, 27, 2, '2020-11-18 15:17:47');

-- --------------------------------------------------------

--
-- Table structure for table `item_import`
--

CREATE TABLE `item_import` (
  `id` int(11) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `import_quantity` int(10) UNSIGNED DEFAULT NULL,
  `import_datetime` timestamp NOT NULL DEFAULT current_timestamp(),
  `import_remark` tinytext DEFAULT 'ARRIVAL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item_import`
--

INSERT INTO `item_import` (`id`, `item_id`, `import_quantity`, `import_datetime`, `import_remark`) VALUES
(1, 1, 5, '2020-11-11 10:39:20', 'ARRIVAL'),
(2, 2, 10, '2020-11-11 10:40:52', 'ARRIVAL'),
(3, 3, 10, '2020-11-11 10:41:16', 'ARRIVAL'),
(4, 4, 2, '2020-11-11 10:47:09', 'ARRIVAL'),
(5, 5, 9, '2020-11-11 10:53:06', 'ARRIVAL'),
(6, 10, 25, '2020-11-11 11:05:23', 'ARRIVAL'),
(7, 7, 7, '2020-11-12 04:24:33', 'ARRIVAL'),
(8, 2, 1, '2020-11-13 05:31:45', 'RETURN'),
(9, 3, 1, '2020-11-13 05:31:45', 'RETURN'),
(10, 4, 1, '2020-11-13 05:31:45', 'RETURN'),
(11, 10, 2, '2020-11-13 05:31:45', 'RETURN'),
(12, 10, 5, '2020-11-13 06:04:22', 'RETURN'),
(13, 6, 5, '2020-11-13 09:54:20', 'ARRIVAL'),
(14, 6, 15, '2020-11-13 09:55:00', 'ARRIVAL'),
(15, 8, 8, '2020-11-14 05:53:22', 'ARRIVAL'),
(16, 9, 9, '2020-11-14 05:53:49', 'ARRIVAL'),
(17, 11, 5, '2020-11-14 06:36:44', 'ARRIVAL'),
(18, 14, 5, '2020-11-17 04:53:16', 'ARRIVAL'),
(19, 27, 3, '2020-11-17 04:53:47', 'ARRIVAL'),
(20, 29, 5, '2020-11-17 04:54:16', 'ARRIVAL'),
(21, 27, 3, '2020-11-18 15:16:57', 'ARRIVAL'),
(22, 31, 7, '2020-11-19 09:56:31', 'ARRIVAL'),
(23, 32, 5, '2020-11-19 09:56:43', 'ARRIVAL'),
(24, 33, 7, '2020-11-19 09:56:53', 'ARRIVAL'),
(25, 28, 10, '2020-11-19 09:57:53', 'ARRIVAL'),
(26, 8, 10, '2020-11-19 09:58:27', 'ARRIVAL'),
(27, 20, 3, '2020-11-19 09:58:42', 'ARRIVAL'),
(28, 30, 9, '2020-11-19 09:59:37', 'ARRIVAL'),
(29, 15, 7, '2020-11-19 10:00:11', 'ARRIVAL');

-- --------------------------------------------------------

--
-- Table structure for table `list_item`
--

CREATE TABLE `list_item` (
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `list_item`
--

INSERT INTO `list_item` (`order_id`, `item_id`, `quantity`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1),
(1, 10, 5),
(2, 1, 3),
(2, 2, 1),
(2, 10, 3),
(3, 2, 1),
(3, 3, 1),
(3, 4, 1),
(3, 10, 2),
(4, 2, 1),
(4, 3, 1),
(4, 4, 1),
(4, 10, 5),
(6, 10, 5),
(7, 6, 6),
(11, 2, 1),
(12, 2, 1),
(12, 3, 1),
(25, 7, 1),
(25, 14, 3),
(25, 27, 2),
(25, 29, 2),
(26, 27, 2),
(27, 7, 2),
(27, 14, 6),
(27, 15, 4),
(27, 28, 2),
(28, 8, 5),
(28, 9, 5),
(28, 28, 5),
(28, 30, 5),
(28, 32, 2),
(29, 2, 1),
(29, 9, 1),
(30, 1, 1),
(30, 6, 1),
(30, 10, 2),
(30, 27, 1),
(31, 2, 4),
(31, 3, 4),
(31, 6, 2),
(31, 14, 5),
(31, 15, 12),
(31, 16, 4),
(31, 32, 2),
(31, 33, 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_request`
--

CREATE TABLE `order_request` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `status` tinytext DEFAULT 'PENDING',
  `address` text NOT NULL,
  `description` text DEFAULT NULL,
  `create_datetime` timestamp NOT NULL DEFAULT current_timestamp(),
  `due_datetime` timestamp NULL DEFAULT NULL,
  `last_update_datetime` timestamp NULL DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_request`
--

INSERT INTO `order_request` (`id`, `name`, `status`, `address`, `description`, `create_datetime`, `due_datetime`, `last_update_datetime`, `customer_id`) VALUES
(1, 'ติดตั้งอินเทอร์เน็ต Fiber 300/300 Mbps', 'SUCEES', '60/300 รามอินทรา กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 05:16:21', '2020-11-18 10:39:20', '2020-11-13 05:16:21', 1),
(2, 'ติดตั้งอินเทอร์เน็ต Fiber 500/200 Mbps', 'SUCCESS', '110/10 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง บ้านรั้วขาว ซอยแรก', '2020-11-11 13:41:40', '2020-11-16 01:35:20', '2020-11-13 05:30:45', 2),
(3, 'ติดตั้งอินเทอร์เน็ต Fiber 100/50 Mbps', 'CANCEL', '10/3 รามอินทรา 63 กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-12 16:21:12', '2020-11-18 18:10:35', '2020-11-13 05:31:45', 3),
(4, 'ติดตั้งอินเทอร์เน็ต Fiber 50/30 Mbps', 'CANCEL', '20/35 รามอินทรา 47 กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-12 16:57:19', '2020-11-12 09:57:19', '2020-11-13 05:57:42', 4),
(5, 'ติดตั้งอินเทอร์เน็ต Fiber 50/30 Mbps', 'CANCEL', '55/31 รามอินทรา 47 กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-12 17:16:00', '2020-12-04 22:12:12', '2020-11-13 05:51:36', 5),
(6, 'ติดตั้งอินเทอร์เน็ต Fiber 50/30 Mbps', 'CANCEL', '88/18 รามอินทรา 40 กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-12 17:31:47', '2020-12-07 08:13:00', '2020-11-13 06:04:22', 5),
(7, 'ติดตั้งอินเทอร์เน็ต Fiber 50/30 Mbps', 'PROGRESS', '80/20 รามอินทรา 40 กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-12 17:33:04', '2020-12-07 01:13:00', '2020-11-13 09:55:29', 6),
(8, 'test', 'CANCEL', 'ทดสอบ', 'ทดสอบ', '2020-11-13 09:40:53', '2020-12-17 18:06:33', '2020-11-13 09:43:34', 1),
(9, 'ติดตั้งอินเทอร์เน็ต Fiber 50/30 Mbps', 'CANCEL', '10/10 รามอินทรา 40 กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-12 17:34:51', '2020-12-07 11:18:00', '2020-11-18 14:46:17', 7),
(10, 'ติดตั้งอินเทอร์เน็ต Fiber 10/10 Mbps', 'CANCEL', '60/300 รามอินทรา กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 05:28:45', '2020-11-18 10:39:20', '2020-11-19 09:48:35', 1),
(11, 'ติดตั้งอินเทอร์เน็ต Fiber 50/30 Mbps', 'CANCEL', '85/45 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 07:14:43', '2020-11-17 09:10:00', '2020-11-13 07:17:13', 2),
(12, 'ติดตั้งอินเทอร์เน็ต Fiber 50/30 Mbps', 'SUCCESS', '85/45 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 07:17:38', '2020-11-17 09:10:00', '2020-11-13 07:20:23', 2),
(13, 'ติดตั้งอินเทอร์เน็ต Fiber 800/100 Mbps', 'CANCEL', '90/45 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 09:25:01', '2020-11-17 09:10:00', '2020-11-19 09:48:37', 3),
(14, 'ติดตั้งอินเทอร์เน็ต Fiber 1500/100 Mbps', 'CANCEL', '90/45 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 09:29:04', '2020-11-17 09:10:00', '2020-11-19 09:48:39', 3),
(15, 'ติดตั้งอินเทอร์เน็ต Fiber 1500/100 Mbps', 'CANCEL', '90/45 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 09:30:10', '2020-11-17 09:10:00', '2020-11-19 09:48:42', 4),
(16, 'ติดตั้งอินเทอร์เน็ต Fiber 1500/100 Mbps', 'CANCEL', '90/45 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 09:32:45', '2020-11-17 09:10:00', '2020-11-19 09:48:44', 4),
(17, 'ติดตั้งอินเทอร์เน็ต Fiber 1500/100 Mbps', 'CANCEL', '90/45 คณาทรัพย์ กรุงเทพฯ 10510', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 09:35:55', '2020-11-17 09:10:00', '2020-11-19 09:48:46', 4),
(18, 'ติดตั้งอินเทอร์เน็ต Fiber 100/100 Mbps', 'CANCEL', '90/45 บึงทองหลาง ปทุมธานี 12150', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-13 09:42:22', '2021-01-05 01:00:00', '2020-11-19 09:48:49', 7),
(22, 'ติดตั้งอินเทอร์เน็ต Fiber 100/100 Mbps', 'CANCEL', '1/5 บึงทองหลาง ปทุมธานี 12150', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-14 14:37:12', '2021-01-07 00:00:00', '2020-11-19 09:48:51', 8),
(24, 'ติดตั้งอินเทอร์เน็ต Fiber 100/100 Mbps', 'CANCEL', '2/7 บึงทองหลาง ปทุมธานี 12150', 'ติดตั้งอุปกรณ์ ฟรีค่าแรง', '2020-11-14 14:45:54', '2021-01-07 02:00:00', '2020-11-19 09:48:53', 9),
(25, 'ติดตั้งอุปกรณ์ Mesh WiFi ชั้น 2 และ 3', 'SUCCESS', '60/300 รามอินทรา 40 แยก 33', 'ต้องการ Router Asus AX\r\nที่บ้านติดตั้ง Fiber ชั้น 1 เรียบร้อยแล้ว', '2020-11-17 04:50:20', '2020-11-27 02:15:00', '2020-11-17 04:59:44', 1),
(26, 'ติดตั้งอุปกรณ์ Mesh WiFi', 'SUCCESS', '18/35 รามอินทรา กรุงเทพฯ 10230', 'ติดตั้งอุปกรณ์เพิ่ม\r\nฟรีค่าแรง', '2020-11-18 15:16:17', '2020-11-17 17:00:00', '2020-11-18 15:18:18', 11),
(27, 'เดินสาย LAN จากชั้น 1 ไป ชั้น 2', 'PENDING', '1415 ถ.กรุงเทพ-นนทบุรี แขวงวงศ์สว่าง เขตบางซื่อ กรุงเทพฯ 10800', 'บริษัท กรุงเทพประกันชีวิต จำกัด (มหาชน) - สำนักงานใหญ่\r\nต้องการ Router AX', '2020-11-19 09:47:49', '2020-11-21 10:14:00', '2020-11-19 09:47:49', 13),
(28, 'ติดตั้งอุปกรณ์ Mesh WiFi', 'PENDING', '25 ถนนสาทรใต้ แขวงทุ่งมหาเมฆ เขตสาทร กรุงเทพฯ 10120', 'สำนักงานใหญ่ อาคารกรุงเทพประกันภัย\r\nโทรศัพท์ 0 2285 8888\r\nโทรสาร 0 2610 2100\r\nเวลาทำการ จ.- ศ. เวลา 08.00 – 17.00 น.\r\n\r\nต้องการอุปกรณ์ TP Link', '2020-11-19 09:55:08', '2020-11-23 03:22:00', '2020-11-19 09:55:08', 14),
(29, 'BROADBAND Advance PACKAGE 500/500', 'PENDING', '7,9 ซอยพระราม 2 (60/2) ถนนพระราม 2 แขวงแสมดำ เขตบางขุนเทียน กรุงเทพฯ 10150', 'ฟรีค่าแรกเข้า ฟรีค่าติดตั้ง\r\n\r\nโทร 0-2452-6103-6', '2020-11-19 10:06:39', '2020-11-25 04:30:16', '2020-11-19 10:06:39', 3),
(30, 'Gigatex Fiber 200/200 Mbps', 'PENDING', '110/10 ซอย คณาทรัพย์ แขวง บางชัน เขต คลองสามวา กรุงเทพมหานคร 10510', 'อยู่ซอยแรก ข้างหน้าซอยมีร้านเหล็กดัด\r\nฟรีค่าติดตั้ง ฟรีกล่อง Inno Hybrid Plus', '2020-11-19 10:12:37', '2020-11-26 03:25:00', '2020-11-19 10:12:37', 2),
(31, 'ติดตั้งอินเทอร์เน็ตสำนักงาน 1000/1000Mbps', 'PENDING', '355 ถนนบอนด์สตรีท ตำบลบางพูด อำเภอปากเกร็ด จังหวัดนนทบุรี 11120', 'สำนักงานใหญ่\r\nโทรศัพท์ : 0 2503 4116-21\r\nโทรสาร : 0 2503 4400\r\n\r\n', '2020-11-19 10:17:06', '2020-12-01 02:35:00', '2020-11-19 10:17:06', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_export`
--
ALTER TABLE `item_export`
  ADD PRIMARY KEY (`order_id`,`item_id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `item_import`
--
ALTER TABLE `item_import`
  ADD PRIMARY KEY (`id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `list_item`
--
ALTER TABLE `list_item`
  ADD PRIMARY KEY (`order_id`,`item_id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `order_request`
--
ALTER TABLE `order_request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfxjv0s37wwv4q392ftjueij4s` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `item_import`
--
ALTER TABLE `item_import`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `order_request`
--
ALTER TABLE `order_request`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item_export`
--
ALTER TABLE `item_export`
  ADD CONSTRAINT `item_export_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_request` (`id`),
  ADD CONSTRAINT `item_export_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

--
-- Constraints for table `item_import`
--
ALTER TABLE `item_import`
  ADD CONSTRAINT `item_import_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

--
-- Constraints for table `list_item`
--
ALTER TABLE `list_item`
  ADD CONSTRAINT `list_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_request` (`id`),
  ADD CONSTRAINT `list_item_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

--
-- Constraints for table `order_request`
--
ALTER TABLE `order_request`
  ADD CONSTRAINT `FKfxjv0s37wwv4q392ftjueij4s` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
