package com.example.homefit.presentation.workout

import com.example.homefit.R
import com.example.homefit.presentation.exercise.ExerciseCategory


data class SubCategoryData(
    val id: Int,
    val name: String,
    val image: Int,
    val category: ExerciseCategory
)

object SubWorkoutData {
    val subExerciseList = listOf(
        SubCategoryData(
            1,
            "Standard Push_Up",
            R.drawable.single_standard_pushup,
            ExerciseCategory.CHEST,

        ), SubCategoryData(
            2,
            "Knee Push_Up",
            R.drawable.single_knee_pushup,
            ExerciseCategory.CHEST,

        ), SubCategoryData(
            3,
            "Wide Push_Up",
            R.drawable.single_wide_pushup,
            ExerciseCategory.CHEST,

        ), SubCategoryData(
            4,
            "Diamond Push_Up",
            R.drawable.single_diamond_pushup,
            ExerciseCategory.CHEST,

        ), SubCategoryData(
            5,
            "Incline Push_Up",
            R.drawable.single_incline_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            6,
            "Decline Push_Up",
            R.drawable.single_decline_pushup,
            ExerciseCategory.CHEST

        ), SubCategoryData(
            7,
            "Archer Push_Up",
            R.drawable.single_archer_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            8,
            "Spiderman Push_Up",
            R.drawable.single_spiderman,
            ExerciseCategory.CHEST

        ), SubCategoryData(
            9,
            "Staggered Push_Up",
            R.drawable.single_staggeres_pushup,
            ExerciseCategory.CHEST

        ), SubCategoryData(
            10,
            "Explosive Push_Up",
            R.drawable.single_explosive_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            11,
            "Hindu Push_Up",
            R.drawable.single_hindu_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            12,
            "Pike Push_Up",
            R.drawable.single_pike_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            13,
            "Slow Tempo Push_Up",
            R.drawable.single_slow_tempo_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            14,
            "Clap Push_UP",
            R.drawable.single_clap_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            15,
            "One Arm Push-up",
            R.drawable.single_one_arm_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            16,
            "Decline Diamond Push-up",
            R.drawable.single_decline_diamond_pushup,
            ExerciseCategory.CHEST
        ), SubCategoryData(
            17,
            "Diamond Push_Up",
            R.drawable.single_diamond_pushup,
            ExerciseCategory.ARMS
        ), SubCategoryData(
            18,
            "Close Grip Push_Up",
            R.drawable.single_close_grip_pushup,
            ExerciseCategory.ARMS
        ), SubCategoryData(
            19,
            "Triceps Push_Up ",
            R.drawable.single_tricep_pushup,
            ExerciseCategory.ARMS
        ), SubCategoryData(
            20,
            "Bench/Chair Dip",
            R.drawable.single_bench_dip,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            21,
            "Plank Up_Down",
            R.drawable.single_plank_up_down,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            22,
            "Commando Plank",
            R.drawable.single_commando_plank,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            23,
            "Reverse Plank Hold",
            R.drawable.single_reverse_plank_hold,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            24,
            "Crab Walk",
            R.drawable.single_crab_walk,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            25,
            "One Arm Push_Up",
            R.drawable.single_one_arm_pushup,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            26,
            "Triceps Push_Up",
            R.drawable.single_tricep_pushup,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            27,
            "Bear Crawl",
            R.drawable.single_bear_crawl,
            ExerciseCategory.ARMS,

        ), SubCategoryData(
            28,
            "Pike Push_up",
            R.drawable.single_pike_pushup,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            29,
            "Wall Pike Hold",
            R.drawable.single_wall_pikr_hold,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            30,
            "Shoulder Tap",
            R.drawable.single_shoulder_tap,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            31,
            "Arm Circle",
            R.drawable.single_arm_circle,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            32,
            "Wall Walk",
            R.drawable.single_wall_walk,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            33,
            "Handstand Hold",
            R.drawable.single_handstand_hold,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            34,
            "Handstand Push_Up",
            R.drawable.single_handstand_pushup,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            35,
            "Downward Dog Push_Up",
            R.drawable.single_downward_dog,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            36,
            "Plank Shoulder Tap",
            R.drawable.single_shoulder_tap,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            37,
            "Superman Raise",
            R.drawable.single_superman,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            38,
            "Y Raise",
            R.drawable.single_y_raise,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            39,
            "Reverse Snow Angel",
            R.drawable.single_reverse_snow_angel,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            40,
            "Hindu Push_Up",
            R.drawable.single_hindu_pushup,
            ExerciseCategory.SHOULDER,

        ), SubCategoryData(
            41, "Crunch",
            R.drawable.single_crunch,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            42, "Sit_Up",
            R.drawable.single_sit_up,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            43,
            "Bicycle Crunch",
            R.drawable.single_bicycle_crunch,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            44,
            "Mountain Climber",
            R.drawable.single_mountain_climber,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            45,
            "Leg Raise",
            R.drawable.single_leg_raise,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            46,
            "Flutter Kick",
            R.drawable.single_flutter_kick,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            47,
            "Russian Twist",
            R.drawable.single_russian_twist,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            48, "Plank",
            R.drawable.single_plank,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            49,
            "Side Plank",
            R.drawable.single_side_plank,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            50, "Dead Bug",
            R.drawable.single_dead_bug,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            51, "V_Up",
            R.drawable.single_v_up,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            52,
            "Hollow Hold",
            R.drawable.single_hollow_body_hold,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            53,
            "Toes To Bar",
            R.drawable.single_toes_to_bar,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            54,
            "Scissor Kick",
            R.drawable.single_scissor_kcik,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            55, "Superman",
            R.drawable.single_superman,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            56,
            "Plank Jack",
            R.drawable.single_plank_jack,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            57,
            "L Sit",
            R.drawable.single_l_sit,
            ExerciseCategory.CORE,

        ), SubCategoryData(
            58,
            "Bodyweight Squat",
            R.drawable.single_bodyweight_squat,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            59,
            "Curtsy Lunge",
            R.drawable.single_curtsy_lunge,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            60,
            "Sumo Squat",
            R.drawable.single_sumo_jump_squat,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            61,
            "Jump Squat",
            R.drawable.single_jump_squat,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            62,
            "Reverse Lunge",
            R.drawable.single_reverse_lunge,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            63,
            "Jump Lunge",
            R.drawable.single_jump_lunge,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            64, "Wall Sit",
            R.drawable.single_wall_sit,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            65,
            "Calf Raise",
            R.drawable.single_singel_calf_raise,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            66,
            "Single Leg Squat",
            R.drawable.singel_leg_squat,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            67,
            "Bulgarian Split Squat",
            R.drawable.single_bilgarian_split_squat,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            68, "Step Up",
            R.drawable.single_step_up,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            69,
            "Side Lunge",
            R.drawable.single_side_lunge,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            70,
            "Curtsy Lunge",
            R.drawable.single_curtsy_lunge,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            71,
            "Single Leg Calf Raise",
            R.drawable.single_leg_calf_raise,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            72,
            "Frog Jump",
            R.drawable.single_frog_jump,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            73,
            "Squat Hold",
            R.drawable.single_squat_hold,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            74,
            "Broad Jump",
            R.drawable.single_broad_jump,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            75,
            "Cossack Squat",
            R.drawable.single_cossack_squat,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            76,
            "Walking Lunge",
            R.drawable.single_walking_lunge,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            77,
            "Pulse Squat",
            R.drawable.single_pulse_squat,
            ExerciseCategory.LEGS,

        ), SubCategoryData(
            78, "Burpee",
            R.drawable.single_burpees,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            79,
            "Mountain Climber",
            R.drawable.single_mountain_climber,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            80,
            "Jumping Jack",
            R.drawable.single_jumping_jack,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            81,
            "High Knee",
            R.drawable.single_high_knee,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            82,
            "Skater Jump",
            R.drawable.single_skaters,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            83,
            "Jump Rope",
            R.drawable.single_invisible_rope,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            84,
            "Bear Crawl",
            R.drawable.single_bear_crawl,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            85,
            "Crab Walk",
            R.drawable.single_crab_walk,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            86,
            "Butt Kick",
            R.drawable.single_butt_kick,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            87,
            "Sprint In Place",
            R.drawable.single_sprint_in_place,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            88,
            "Star Jump",
            R.drawable.single_star_jump,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            89,
            "Tuck Jump",
            R.drawable.single_tuck_jump,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            90,
            "Jump Squat",
            R.drawable.single_jump_squat,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            91,
            "Fast Feet",
            R.drawable.single_fast_feet,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            92,
            "Lateral Hops",
            R.drawable.single_lateral_hope,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            93,
            "Power Skips",
            R.drawable.single_power_skips,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            94,
            "Side Shuffle",
            R.drawable.single_side_shuffle,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            95,
            "Squat Thrust",
            R.drawable.single_squat_thrust,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            96,
            "Frog Jump",
            R.drawable.single_frog_jump,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            97,
            "Jump Lunge",
            R.drawable.single_jump_lunge,
            ExerciseCategory.CARDIO,

        ), SubCategoryData(
            98,
            "Jumping Jack",
            R.drawable.single_jumping_jack,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            99,
            "High Knee",
            R.drawable.single_high_knee,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            100,
            "Butt Kick",
            R.drawable.single_butt_kick,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            101,
            "Arm Circle",
            R.drawable.single_arm_circle,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            102,
            "Leg Swings",
            R.drawable.single_leg_swings,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            103,
            "Hip Circle",
            R.drawable.single_hip_rotation,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            104,
            "Torso Twists",
            R.drawable.single_torso_twist,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            105,
            "Neck Rolls",
            R.drawable.single_neck_rotation,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            106,
            "Shoulder Roll",
            R.drawable.single_shoulder_roll,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            107,
            "Side Bend",
            R.drawable.single_side_bend,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            108,
            "Standing Knee Hugs",
            R.drawable.single_standing_knee_hug,
            ExerciseCategory.WARM_UP,

        ), SubCategoryData(
            109, "Superman",
            R.drawable.single_superman,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            110, "Bird Dog",
            R.drawable.single_bird_dog,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            111,
            "Reverse Snow Angel",
            R.drawable.single_reverse_snow_angel,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            112,
            "Wall Angel",
            R.drawable.single_wall_angel,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            113,
            "Back Extension",
            R.drawable.single_back_extension,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            114,
            "Superman Hold",
            R.drawable.single_superman_hold,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            115,
            "Alternating Superman",
            R.drawable.single_alternating_superman,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            116, "Swimmer",
            R.drawable.single_swimmer,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            117,
            "Reverse Plank",
            R.drawable.single_reverse_plank,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            118,
            "Reverse Plank Leg Raise",
            R.drawable.single_reverse_plank_leg,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            119,
            "Bear Crawl",
            R.drawable.single_bear_crawl,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            120,
            "Crab Walk",
            R.drawable.single_crab_walk,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            121,
            "Dead Hang",
            R.drawable.single_dead_hang,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            122, "Pull-Up",
            R.drawable.single_pullup,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            123, "Chin-Up",
            R.drawable.single_chinup,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            124, "Australian Pull-Up",
            R.drawable.single_australian_pushup,
            ExerciseCategory.BACK,

        ), SubCategoryData(
            125,
            "Neck Stretch",
            R.drawable.single_neck_rotation,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            126,
            "Shoulder Stretch",
            R.drawable.singel_shoulder_stretch,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            127,
            "Cross-Body Shoulder Stretch",
            R.drawable.single_cross_body_shoulder,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            128,
            "Overhead Triceps Stretch",
            R.drawable.single_overhead_tricep,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            129,
            "Cat-Cow Stretch",
            R.drawable.single_cat_cow,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            130,
            "Child's Pose",
            R.drawable.single_child_pose,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            131,
            "Cobra Stretch",
            R.drawable.single_cobra_stretch,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            132,
            "Thread the Needle",
            R.drawable.single_thread_the_needle,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            133,
            "Figure Four Stretch",
            R.drawable.single_figure_four,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            134,
            "Butterfly Stretch",
            R.drawable.single_butterfly_stretch,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            135,
            "Hip Flexor Stretch",
            R.drawable.single_hip_flexor,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            136,
            "Pigeon Pose",
            R.drawable.singel_pigeon_pose,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            137,
            "Standing Hamstring Stretch",
            R.drawable.single_standing_hamstring,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            138,
            "Quad Stretch",
            R.drawable.single_quad_stretch,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            139,
            "Calf Stretch",
            R.drawable.single_calf_stretch,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            140,
            "Toe Touch Stretch",
            R.drawable.single_toe_touch,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            141,
            "Downward Dog",
            R.drawable.single_downward_dog,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            142,
            "World's Greatest Stretch",
            R.drawable.single_world_greatest,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            143,
            "Inchworm Stretch",
            R.drawable.single_inchwarm,
            ExerciseCategory.STRETCHING,

        ), SubCategoryData(
            144,
            "Deep Squat Hold",
            R.drawable.single_deep_squat,
            ExerciseCategory.STRETCHING,

        )
    )
}

